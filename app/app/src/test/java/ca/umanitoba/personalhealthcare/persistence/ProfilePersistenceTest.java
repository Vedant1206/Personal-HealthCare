package ca.umanitoba.personalhealthcare.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

public class ProfilePersistenceTest {
    final int SAMPLE_SIZE = 10;
    ProfilePersistence profilePersistence;
    Profile[] sampleProfiles;
    String email;

    @Before
    public void setUp () {
        email = "random@email.com";
        profilePersistence = FakeProfilePersistence.getProfilePersistence();
        sampleProfiles = new Profile[SAMPLE_SIZE];
        for (int i = 0; i < SAMPLE_SIZE; i ++) {
            sampleProfiles[i] = new Profile(email, "Default"+i,
                    "address"+i, i, i, 2020, 6, 1, "male");
        }
        for (Profile profile : sampleProfiles) {
            try {
                profilePersistence.insertProfile(profile);
            } catch (NameExistsException e) {
                assertTrue(false);
            }
        }
    }

    @After
    public void cleanUp () {
        for (int i = 0; i < SAMPLE_SIZE; i ++) {
            sampleProfiles[i] = new Profile(email, "Default"+i,
                    "address"+i, i, i, 2020, 6, 1, "male");
            profilePersistence.deleteProfile(sampleProfiles[i]);
        }
    }

    @Test
    public void testInsertProfile () {
        for (Profile profile : sampleProfiles) {
            assertThrows(NameExistsException.class, () -> {
                profilePersistence.insertProfile(profile);
            });
        }
    }

    @Test
    public  void testUpdateProfileSameName () {
        for (int i = 0; i < SAMPLE_SIZE; i ++) {
            Profile profile = sampleProfiles[i];
            profile.setAddress("NewAddress"+i);
            profilePersistence.updateProfile(profile);
        }
        for (int i = 0; i < SAMPLE_SIZE; i ++) {
            Profile profile = profilePersistence.getProfile(email, "Default"+i);
            assertNotNull(profile);
            assertEquals(profile.getAddress(),"NewAddress"+i);
            profilePersistence.updateProfile(profile);
        }
    }

    @Test
    public  void testUpdateProfileDifferentName () {
        for (int i = 0; i < SAMPLE_SIZE; i ++) {
            Profile profile = sampleProfiles[i];
            String initName = profile.getName();
            String newName = "New"+initName;
            System.out.println("Init: " + initName + " - New: " + newName);
            profile.setName(newName);
            try {
                profilePersistence.updateProfileName(profile, initName);
            } catch (NameExistsException e) {
                assertTrue(false);
            }

            Profile getProfile = profilePersistence.getProfile(email, initName);
            assertNull(getProfile);
            getProfile = profilePersistence.getProfile(email, newName);
            sampleProfiles[i] = getProfile;

            assertNotNull(getProfile);
        }
    }

    @Test
    public  void testUpdateProfileDifferentNameException () {
        for (int i = 0; i < SAMPLE_SIZE-1; i ++) {
            Profile profile = sampleProfiles[i];
            String profileName = profile.getName();
            profile.setName("Default" + (i+1));
            assertThrows(NameExistsException.class, () -> {
                profilePersistence.updateProfileName(profile, profileName);
            });
            profile.setName(profileName);
        }
    }

    @Test
    public void testDeleteProfile () {
        for (Profile profile : sampleProfiles) {
            String profileName = profile.getName();
            Profile getProfile = profilePersistence.getProfile(email, profileName);
            assertNotNull(getProfile);
            profilePersistence.deleteProfile(profile);
            getProfile = profilePersistence.getProfile(email, profileName);
            assertNull(getProfile);
        }
    }

    @Test
    public void testGetProfiles() {
        List<Profile> profiles = profilePersistence.getProfiles(email);

        assertEquals(profiles.size(), SAMPLE_SIZE);
    }

    @Test
    public  void testGetProfile () {
        for (int i = 0; i < SAMPLE_SIZE; i ++ ) {
            Profile profile = profilePersistence.getProfile(email, "Default"+i);
            assertNotNull(profile);
        }
        for (int i = 10; i < SAMPLE_SIZE+10; i ++ ) {
            Profile profile = profilePersistence.getProfile(email, "Default"+i);
            assertNull(profile);
        }
    }
}
