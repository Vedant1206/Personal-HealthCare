package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;


public class FakeProfilePersistence implements ProfilePersistence {
    public static ProfilePersistence profilePersistence;
    private ArrayList<Profile> profiles;
    private FakeProfilePersistence(){profiles = new ArrayList<>();}

    public static ProfilePersistence getProfilePersistence(){
        if(profilePersistence == null){
            profilePersistence = new FakeProfilePersistence();
        }
        return profilePersistence;
    }

    @Override
    public Profile getProfile(String email, String profileName){
        for(Profile profile : profiles){
            if(profile.getEmail().equals(email) && profile.getName().equals(profileName)){
                return profile;
            }
        }
        return null;
    }

    @Override
    public boolean createProfile(Profile newProfile) throws NameExistsException, EmailExistException {
        String name = newProfile.getName();
        String email = newProfile.getEmail();
        boolean check = checkProfile(email, name);
        boolean created = true;
        if(check){
            for (Profile profile: profiles){
                if(profile.getEmail().equals(email)){
                    throw new EmailExistException();
                }
                if(profile.getName().equals(name)){
                    throw new NameExistsException();
                }
            }
        }
        this.profiles.add(newProfile);
        return created;
    }

    @Override
    public boolean deleteProfile(String email, String profileName){
        boolean check = checkProfile(email, profileName);
        boolean deleted = true;
        if(check = true){
            profiles.remove(check);
            return deleted;

        }
        return !deleted;
    }

    @Override
    public boolean checkProfile(String email, String profileName){
        boolean checked = true;
        for(Profile profile: profiles){
            if(profile.getEmail().equals(email) && profile.getName().equals(profileName)){
                return checked;
            }
        }
        return !checked;

    }

}