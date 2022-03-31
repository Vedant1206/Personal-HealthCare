package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;
import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;


import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistnece;
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
        //------------------------------Area maybe need be rework
        if(profiles == null || members == null){
            profiles = new FakeProfilePersistence();
            members = new FakeMemberPersistence();
        }
        this.selectedMember = members.getMember(email, password);
        //TODO: create a fake persistence
        //------------------------------Area need be rework
        //TODO: Refactor the constructor after the LoginSession create.


    }

    public ProfileManagerImp(Member selectedMember){
        if(profiles == null || members == null){
            profiles = new FakeProfilePersistence();
            members = new FakeMemberPersistence();
        }
        this.selectedMember = selectedMember;

    }

    @Override
    public Profile insertProfile(Profile newProfile) {
        return profiles.insertProfile(newProfile);
    }

    @Override
    public void deleteProfile(Profile profileDeleting){
        profiles(profileDeleting);
    }

    @Override
    public List<Profile> getProfile(Member selectedMember){
        List<Profile> lookingFor = profiles.getProfile(selectedMember);
        return lookingFor;
    }


}
