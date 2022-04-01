package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import java.util.ArrayList;
import java.util.List;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;


public class FakeProfilePersistence implements ProfilePersistence {
    public static FakeProfilePersistence profilePersistence;
    private ArrayList<Profile> profiles;
    private FakeProfilePersistence(){profiles = new ArrayList<>();}

    public static ProfilePersistence getProfilePersistence(){
        if(profilePersistence == null){
            profilePersistence = new FakeProfilePersistence();
        }
        return profilePersistence;
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
        try{
            insertProfileException(currentProfile);

        }catch (NameExistsException exception){
            exception.printStackTrace();
        }

        return currentProfile;

    }

    public boolean insertProfileException(Profile currentProfile) throws NameExistsException{
        for(Profile profile: profiles){
            if(profile.getName().equals(currentProfile.getName()) && profile.getEmail().equals(currentProfile.getEmail())){
                throw new NameExistsException();
            }
        }
        return true;
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

        return currentProfile;
    }



}