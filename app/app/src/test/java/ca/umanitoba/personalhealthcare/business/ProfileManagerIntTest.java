package ca.umanitoba.personalhealthcare.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.ProfilePersistenceHSQLDB;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.business.ProfileManager;



public class ProfileManagerIntTest{
    private ProfileManager profileManager;
    private ProfilePersistence profilePersistence;

    @Before
    public void setUp(){
        profilePersistence = new ProfilePersistenceHSQLDB();
        profileManager = new ProfileManagerImp(profilePersistence);
    }


    @Test
    public void testInsertProfile(){
        String email = "email1@myumanitoba.ca";
        String name = "Alexander";
        String address = "Street1 City1";
        int height = 170;
        int weight = 77;
        int year = 2002;
        int month = 3;
        int day = 25;
        String sex = "M";
        try{
            profileManager.insertProfile(email, name, address, height, weight, year, month, day, sex);
        } catch (NameExistsException exception){
            // if throw exception -> fail
            assertEquals(1,2);
        }
        assertEquals(4, (profileManager.getProfile(email)).size());
    }
    @Test
    public void testInsertProfileExistingName() {
        String email = "email1@myumanitoba.ca";
        String name = "James";
        String address = "Street1 City1";
        int height = 170;
        int weight = 77;
        int year = 2002;
        int month = 3;
        int day = 25;
        String sex = "M";
        try{
            profileManager.insertProfile(email, name, address, height, weight, year, month, day, sex);
        }catch (NameExistsException exception){
            // if throw exception -> right
            assertEquals(1,1);
            assertEquals(4, (profileManager.getProfile(email)).size());//check the number of profiles under the given email
        }
    }

    @Test
    public void getProfile(){
        String email1 = "email1@myumanitoba.ca";
        String email2 = "email2@myumanitoba.ca";
        String email3 = "email3@myumanitoba.ca";
        String email4 = "email4@myumanitoba.ca";
        assertEquals(4,(profileManager.getProfile(email1)).size());
        assertEquals(2,(profileManager.getProfile(email2)).size());
        assertEquals(1,(profileManager.getProfile(email3)).size());
        assertEquals(1,(profileManager.getProfile(email4)).size());
    }

    @Test
    public void testUpdateProfile() {
        String email = "email1@myumanitoba.ca";
        String name = "Alexander";
        String address = "Street1 City1";
        int height = 170;
        int weight = 77;
        int year = 2002;
        int month = 3;
        int day = 25;
        String sex = "M";
        Profile beforeUpdate = new Profile(email, name, address, height, weight, year, month, day, sex);
        String newAddress = "Street2 City2";
        int newHeight = height + 1;
        int newWeight = weight + 1;
        int newYear = year + 1;
        int newMonth = month + 1;
        int newDay = day + 1;
        String newSex = "F";
        Profile update = new Profile(email, name, newAddress, newHeight, newWeight, newYear, newMonth, newDay, newSex);
        profileManager.updateProfile(update);
        List<Profile> profiles = profileManager.getProfile(email);
        assertEquals(4, profiles.size());

        Profile get = null;
        for(Profile profile : profiles){
            if((profile.getName()).equals(name)){
                get = profile;
            }
        }

        assertNotEquals(address, get.getAddress());
        assertNotEquals(height, get.getHeight());
        assertNotEquals(weight, get.getWeight());
        assertNotEquals(year, get.getYear());
        assertNotEquals(month, get.getMonth());
        assertNotEquals(day, get.getDay());
        assertNotEquals(sex, get.getSex());

    }

    @Test
    public void testDeleteProfile(){
        String email = "email1@myumanitoba.ca";
        String name = "Alexander";
        String address = "Street1 City1";
        int height = 170;
        int weight = 77;
        int year = 2002;
        int month = 3;
        int day = 25;
        String sex = "M";
        Profile target = new Profile(email, name, address, height, weight, year, month, day, sex);
        assertEquals(4,(profileManager.getProfile(email)).size());
        profileManager.deleteProfile(target);
        assertEquals(3, (profileManager.getProfile(email)).size());
    }

}

