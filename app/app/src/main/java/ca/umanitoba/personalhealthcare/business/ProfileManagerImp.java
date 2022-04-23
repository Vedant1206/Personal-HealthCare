package ca.umanitoba.personalhealthcare.business;

/**
 * The logic layer class that handle profiles
 * The input of this class method can be change in next iteration.
 */
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;

import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;

//import ca.umanitoba.personalhealthcare.business.ProfileManager;
//import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public class ProfileManagerImp implements ProfileManager{
    private ProfilePersistence profilePersistence;
//    private Member selectedMember;
//
//    private MemberPersistence members;

    /**
     * The constructor for ProfileMannagerImp
     *
     * @param profilePersistence getting profilePersistence as input.
     */
    public ProfileManagerImp(ProfilePersistence profilePersistence){
        this.profilePersistence = profilePersistence;
    }

    public Profile insertProfile(String email, String name, String address,
                                 int height, int weight,
                                 int year, int month, int day,
                                 String sex) throws NameExistsException{
        Profile newProfile = new Profile(email, name, address, height, weight, year, month, day, sex);
        profilePersistence.insertProfile(newProfile);
        return newProfile;
    }

    public void deleteProfile(Profile profileDeleting){
        profilePersistence.deleteProfile(profileDeleting);
    }

    public List<Profile> getProfiles(String email){
        List<Profile> lookingFor = profilePersistence.getProfile(email);
        return lookingFor;
    }

    public Profile updateProfile(Profile newProfile){
        return profilePersistence.updateProfile(newProfile);

    }

    @Override
    public Profile getProfile(String email, String profileName) {
        //TODO: to be implemented
        return null;
    }
}
