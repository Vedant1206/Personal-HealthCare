package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;


public class FakeProfilePersistence implements ProfilePersistence {

    private ArrayList<Profile> profiles;
    private FakeProfilePersistence(){profiles = new ArrayList<>();}

    public static ProfilePersistence getProfilePersistence(){
        if(profiles == null){
            profiles = new ArrayList<Profile>();
        }
        return this.profiles;
    }

    @Override
    public List<Profile> getProfile(Member currentMember){
        List<Profile> selectedProfiles = new ArrayList<Profile>();
        for(Profile profile : profiles){
            if(profile.getEmail().equals(currentMember.getEmail())){
                profiles.add(profile);
            }
        }
        return profiles;
    }

    @Override
    public Profile insertProfile(Profile currentProfile){
        if(insertProfileException(currentProfile)) {
            profiles.add(currentProfile);
        }
    }

    public boolean isnertProfileException(Profile currentProfile) throws NameExistsException{
        for(Profile profile: profiles){
            if(profile.getName().equals(currentProfile.getName()) && profile.getEmail().equals(currentProfile.getEmail())){
                throws new NameExistsException;
            }
        }
        return true;
    }

    @Overrride
    public void deleteProfile(Profile currentProfile){
        for(Profile profile: profiles){
            if(profile.getName().equals(currentProfile.getName()) && profile.getEmail().equals(currentProfile.getEmail())){
                profiles.remove(profile);
                return ;
            }
        }
    }


}