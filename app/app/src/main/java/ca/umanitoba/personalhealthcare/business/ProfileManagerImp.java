package ca.umanitoba.personalhealthcare.business;

/**
 * The logic layer class that handle profiles
 * The input of this class method can be change in next iteration.
 */
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;

import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public class ProfileManagerImp implements ProfileManager{
    private ProfilePersistence profilePersistence;  //Profile persistence

    /**
     * The constructor for ProfileMannagerImp
     *
     * @param profilePersistence getting profilePersistence as input.
     */
    public ProfileManagerImp(ProfilePersistence profilePersistence){
        this.profilePersistence = profilePersistence;
    }

    /**
     * insertProfile
     * @param email String
     * @param name String
     * @param address String
     * @param height int
     * @param weight int
     * @param year int
     * @param month int
     * @param day int
     * @param sex String
     * @return Profile
     */
    public Profile insertProfile(String email, String name, String address,
                                 int height, int weight,
                                 int year, int month, int day,
                                 String sex) throws NameExistsException{
        Profile newProfile = new Profile(email, name, address, height, weight, year, month, day, sex);
        profilePersistence.insertProfile(newProfile);
        return newProfile;
    }

    /**
     * deleteProfile
     * @param profileDeleting Profile object
     */
    public void deleteProfile(Profile profileDeleting){
        profilePersistence.deleteProfile(profileDeleting);
    }

    /**
     * getProfiles
     * @param email String
     * @return List
     */
    public List<Profile> getProfiles(String email){
        List<Profile> lookingFor = profilePersistence.getProfiles(email);
        return lookingFor;
    }

    /**
     * updateProfile
     * @param newProfile Profile object
     * @return Profile
     */
    public Profile updateProfile(Profile newProfile){
        return profilePersistence.updateProfile(newProfile);
    }

    /**
     * getProfile
     * @param email String
     * @param profileName String
     * @return Profile
     */
    @Override
    public Profile getProfile(String email, String profileName) {

        return profilePersistence.getProfile(email, profileName);
    }

    /**
     * updateProfileName
     * @param initName String
     * @param profile Profile object
     * @return Profile
     */
    @Override
    public Profile updateProfileName(Profile profile, String initName) throws NameExistsException {
        return profilePersistence.updateProfileName(profile, initName);
    }
}
