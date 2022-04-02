package ca.umanitoba.personalhealthcare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.business.ProfileManagerImp;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public class ProfileManagerUnitTest {
    ProfileManager profileManager;
    Profile test1;
    Profile test2;
    Profile test3;
    String testemail1;
    String testemail2;
    List<Profile> list1;
    List<Profile> list2;
    FakeProfilePersistence f;
    @Before
    public void setup() {

        profileManager = new ProfileManagerImp(FakeProfilePersistence.getProfilePersistence());
        // create the test subject 1
        String email = "Test1@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        test1 = new Profile(email, name, address, height, weight, year, month, day, sex);
        // create the test subject 2
        // test1 and test2 will under same member(email)
        String email2 = "Test1@example.com";
        String name2 = "test2";
        String address2 = "test address2";
        int height2 = 190;
        int weight2 = 190;
        int year2 = 2000;
        int month2 = 11;
        int day2 = 10;
        String sex2 = "f";
        test2 = new Profile(email2, name2, address2, height2, weight2, year2, month2, day2, sex2);
        // create the test subject 3
        String email3 = "Test2@example.com";
        String name3 = "test1";
        String address3 = "test address3";
        int height3 = 178;
        int weight3 = 80;
        int year3 = 2003;
        int month3 = 9;
        int day3 = 11;
        String sex3 = "m";
        test3 = new Profile(email3, name3, address3, height3, weight3, year3, month3, day3, sex3);
        try {
            profileManager.insertProfile(email, name, address, height, weight, year, month, day, sex);
            profileManager.insertProfile(email2, name2, address2, height2, weight2, year2, month2, day2, sex2);
            profileManager.insertProfile(email3, name3, address3, height3, weight3, year3, month3, day3, sex3);
        } catch (NameExistsException e) {
            e.printStackTrace();
            assertEquals(1,0);
        }
        testemail1 = email;
        testemail2 = email3;
    }

    @After()
    public void cleanUp(){

        profileManager.deleteProfile(test1);
        profileManager.deleteProfile(test2);
        profileManager.deleteProfile(test3);

    }

    @Test()
    public void testGetProfile() {

        assertNotNull(profileManager);

        list1 = profileManager.getProfile(testemail1); // all the profiles for the member 1
        assertNotNull(list1);
        list2 = profileManager.getProfile(testemail2); // all the profiles for the member 2
        assertNotNull(list2);
        assertEquals(list1.size(), 2); // total of 2 profiles in the list1
        assertEquals(list2.size(), 1); // total of 1 profiles in the list2
    }

    @Test()
    public void testInsertProfile() {

        String email = "Test5@example.com";
        String name = "test5";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";

        Profile check = null;
        try{
            check =  profileManager.insertProfile(email, name, address, height, weight, year, month, day, sex);
        } catch (NameExistsException exception){
            // if send exception -> error;
            assertEquals(0,1);
        }

        assertNotNull(check);
        assertEquals(check.getName(), "test5");
        assertEquals(check.getEmail(), "Test5@example.com");

    }

    @Test()
    public void testInsertProfileExistingName() {
        String email = "Test1@example.com";
        String name = "test1";
        String address = "test address1";
        int height = 200;
        int weight = 200;
        int year = 2000;
        int month = 12;
        int day = 31;
        String sex = "m";
        Profile insertTest = new Profile(email, name, address, height, weight, year, month, day, sex);

        try{
            profileManager.insertProfile(email, name, address, height, weight, year, month, day, sex);

        }catch(NameExistsException exception){
            // if throw -> right
            assertEquals(1,1);
        }
    }

    @Test()
    public void testDeleteProfile() {

        // create the test subject 4
        String email4 = "Test7@example.com";
        String name4 = "test6";
        String address4 = "test address3";
        int height4 = 178;
        int weight4 = 80;
        int year4 = 2003;
        int month4 = 9;
        int day4 = 11;
        String sex4 = "m";
        Profile test4 = new Profile(email4, name4, address4, height4, weight4, year4, month4, day4, sex4);
        try{
            profileManager.insertProfile(email4, name4, address4, height4, weight4, year4, month4, day4, sex4);
        } catch (NameExistsException e) {
            e.printStackTrace();
            assertEquals(1,0);
        }

        List<Profile> list1; // all the profiles for the member 1
        list1 = profileManager.getProfile(email4);
        assertEquals(list1.size(), 1);
        profileManager.deleteProfile(test4);
        list1 = profileManager.getProfile(email4);
        assertEquals(list1.size(), 0);

    }

    @Test()
    public void testUpdateProfile(){
        List<Profile> list2 = profileManager.getProfile(testemail2);
        Profile target = list2.get(0);
        assertNotNull(target);
        // all the information about target before update
        String email = target.getEmail();
        String name = target.getName();
        String address = target.getAddress();
        int height = target.getHeight();
        int weight = target.getWeight();
        int year = target.getYear();
        int month = target.getMonth();
        int day = target.getDay();
        String sex = target.getSex();
        // new information to update
        String newAddress = "new Address";
        int newHeight = height + 1;
        int newWeight = weight +1;
        int newYear = year -1;
        int newMonth = month +1;
        int newDay = day+1;
        String newSex = "f";
        Profile update = new Profile(email, name, newAddress, newHeight, newWeight, newYear, newMonth, newDay, newSex);
        profileManager.updateProfile(update);
        list2 = profileManager.getProfile(testemail2);
        assertEquals(list2.size(), 1);
        update = list2.get(0);

        assertEquals(update.getEmail(), email);
        assertEquals(update.getName(), name);
        assertNotEquals(update.getAddress(), address);
        assertNotEquals(update.getHeight(), height);
        assertNotEquals(update.getWeight(), weight);
        assertNotEquals(update.getYear(), year);
        assertNotEquals(update.getMonth(), month);
        assertNotEquals(update.getDay(), day);
        assertNotEquals(update.getSex(), sex);
    }



}
