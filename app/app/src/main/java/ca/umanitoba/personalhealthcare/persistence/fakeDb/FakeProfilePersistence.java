package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

/**
 * The Fake data base storing the profiles.
 */
public class FakeProfilePersistence implements ProfilePersistence {
    public static FakeProfilePersistence profilePersistence; //the holding instance of the class
    private ArrayList<Profile> profiles; //db that storing all the profiles
    private FakeProfilePersistence(){profiles = new ArrayList<>();} // constructor for the class

    /**
     * Method to return the persistence of the profile(fake)
     */
    public static ProfilePersistence getProfilePersistence(){
        if(profilePersistence == null){
            //case the empty instance
            profilePersistence = new FakeProfilePersistence();
        }
        return profilePersistence;
    }

    @Override
    public List<Profile> getProfile(String email){
        List<Profile> selectedProfiles = new ArrayList<Profile>();
        for(Profile profile : profiles){
            if(profile.getEmail().equals(email)){
                selectedProfiles.add(profile);
            }
        }
        return selectedProfiles;
    }

    @Override
    public Profile insertProfile(Profile currentProfile) throws NameExistsException{
        for(Profile profile: profiles){
            if(((profile.getName()).equals(currentProfile.getName())) && ((profile.getEmail()).equals(currentProfile.getEmail()))){
                // check same profile name is existing under a email. one email multiple name(profile) but no duplicate name
                throw new NameExistsException();
            }
        }
        profiles.add(currentProfile);
        return currentProfile;
    }

    @Override
    public void deleteProfile(Profile currentProfile){
        for(Profile profile: profiles){
            if(profile.getName().equals(currentProfile.getName()) && profile.getEmail().equals(currentProfile.getEmail())){
                profiles.remove(profile);
                return ;
            }
        }
    }

    @Override
    public Profile updateProfile(Profile currentProfile){
        for(Profile profile: profiles){
            if(profile.getName().equals(currentProfile.getName()) && profile.getEmail().equals(currentProfile.getEmail())){
                profile.setAddress(currentProfile.getAddress());
                profile.setHeight(currentProfile.getHeight());
                profile.setWeight(currentProfile.getWeight());
                profile.setYear(currentProfile.getYear());
                profile.setMonth(currentProfile.getMonth());
                profile.setDay(currentProfile.getDay());
                profile.setSex(currentProfile.getSex());
                return profile;
            }
        }
        return currentProfile;
    }

}
