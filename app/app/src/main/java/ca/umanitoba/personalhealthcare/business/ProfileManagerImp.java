package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;
import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;


import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;

public class ProfileManagerImp implements ProfileManager{
    private ProfilePersistence profiles;
    private Member selectedMember;

    private MemberPersistence members;


    /**
     * The constructor for ProfileManagerImp
     * @param email
     * @param password
     */
    public ProfileManagerImp(String email, String password){

    }

    public ProfileManagerImp(ProfilePersistence profilePersistence){
        this.profiles = profilePersistence;
    }

    /**
     * The constructor for unit testing
     */
    public ProfileManagerImp(){
        profiles = FakeProfilePersistence.getProfilePersistence();
        members = FakeMemberPersistence.getMemberPersistence();
        //TODO: create a fake persistence

    }


    @Override
    public Profile insertProfile(Profile newProfile) {
        return profiles.insertProfile(newProfile);
    }

    @Override
    public void deleteProfile(Profile profileDeleting){
        profiles.deleteProfile(profileDeleting);
    }

    @Override
    public List<Profile> getProfile(Member selectedMember){
        List<Profile> lookingFor = profiles.getProfile(selectedMember);
        return lookingFor;
    }

    @Override
    public Profile updateProfile(Profile newProfile){
        profiles.updateProfile(newProfile);
    }
}
