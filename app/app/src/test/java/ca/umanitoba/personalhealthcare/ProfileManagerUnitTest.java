package ca.umanitoba.personalhealthcare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.business.ProfileManagerImp;
import ca.umanitoba.personalhealthcare.Member;
import ca.umanitoba.personalhealthcare.Profile;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public class ProfileManagerTest {
    ProfileManager profileManager;

    @Before
    public void setup() {
        ProfileManager manager = new ProfileManagerImp();

    }

    @Test()
    public void testInsertProfile() {
        //TODO: Implement it after populate the fake DB
        String email = "Test1@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        Profile test1 = new Profile(email, name, address, height, weight, year, month, day);
        assertNotNull(profileManager.insertProfile(test1));
    }

    @Test()
    public void testInsertProfileExistingName() {
        //TODO: Implement it after populate the fake DB
        String email = "Test1@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        Profile test1 = new Profile(email, name, address, height, weight, year, month, day);
        profile test2 = new Profile(email, name, address, height, weight, year, month, day);
        assertNotNull(profileManager.insertProfile(test1));
        assertThrows(NameExistsException.class, () -> profileManager.insertProfile(test2));

    }

    @Test()
    public void testDeleteProfile() {
        //TODO: Implement it after populate the fake DB
        String email = "Test1@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        Profile test1 = new Profile(email, name, address, height, weight, year, month, day);
        profile test2 = new Profile(email, name, address, height, weight, year, month, day);
        assertNotNull(profileManager.insertProfile(test1));
        assertThrows(NameExistsException.class, () -> profileManager.insertProfile(test2));
        profileManager.deleteProfile(test1);
        assertNotNull(profileManager.insertProfile(test2))
    }

    @Test()
    public void testGetProfile() {
        //TODO: Implement it after populate the fake DB
        String email = "Test1@example.com";
        String email1 = "Test2@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        Profile test1 = new Profile(email, name, address, height, weight, year, month, day);
        profile test2 = new Profile(email1, name, address, height, weight, year, month, day);
    }


}
