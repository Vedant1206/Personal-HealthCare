package ca.umanitoba.personalhealthcare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.business.ProfileManagerImp;
import ca.umanitoba.personalhealthcare.Patient;
import ca.umanitoba.personalhealthcare.Profile;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

public class ProfileManagerTest {
    ProfileManager profileManager;

    @Before
    public void setup() {
        profileManager = new ProfileManagerImp(FakeProfilePersistnece.getProfilePersistence());
    }

    @Test()
    public void testCreateProfile() {
        //TODO: Implement it after populate the fake DB
    }

    @Test()
    public void testCreateProfileExistingName() {
        //TODO: Implement it after populate the fake DB
        try {
        } catch (Exception e) {
        }
        assertThrows(NameExistsException.class, () -> profileManager.createProfile());
    }

    @Test()
    public void testDeleteProfile() {
        //TODO: Implement it after populate the fake DB
    }

    @Test()
    public void testGetProfile() {
        //TODO: Implement it after populate the fake DB
    }

    @After
    public void cleanUp() {
        //TODO: Implement it after populate the fake DB
    }
}
