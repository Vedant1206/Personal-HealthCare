package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;
import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;

//import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;
//import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public class ProfileManagerImp implements ProfileManager{
    private ProfilePersistence profiles;
    private Member selectedMember;

    private MemberPersistence members;

    /**
     * The constructor for ProfileMannagerImp
     *
     * @param profilePersistence getting profilePersistence as input.
     */
    public ProfileManagerImp(ProfilePersistence profilePersistence){
        this.profiles = profilePersistence;
    }

    public Profile insertProfile(String email, String name, String address,
                                 int height, int weight,
                                 int year, int month, int day,
                                 String sex) throws NameExistsException{
        Profile newProfile = new Profile(email, name, address, height, weight, year, month, day, sex);
        profiles.insertProfile(newProfile);
        return newProfile;
    }

    public void deleteProfile(Profile profileDeleting){
        profiles.deleteProfile(profileDeleting);
    }

    public List<Profile> getProfile(String email){
        List<Profile> lookingFor = profiles.getProfile(email);
        return lookingFor;
    }

    public Profile updateProfile(Profile newProfile){
        return profiles.updateProfile(newProfile);

    }
}
