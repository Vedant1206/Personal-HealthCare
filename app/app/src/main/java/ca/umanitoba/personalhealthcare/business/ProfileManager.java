package ca.umanitoba.personalhealthcare.business;
/**
 * The logic layer class that handle profiles
 * The input of this class method can be change in next iteration.
 */

import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;

public interface ProfileManager {

    /**
     * Insert new profile into currently selected member.
     *
     * @param   newProfile the new profile been created.
     * @return  Profile object
     */
    public Profile insertProfile(String email, String name, String address,
                                 int height, int weight,
                                 int year, int month, int day,
                                 String sex) throws NameExistsException;

    /**
     * Delete the profile with the given profile
     * @param Profile profileDeleting the profile we are deleting
     *
     */
    public void deleteProfile(Profile profileDeleting);

    /**
     * Search and get the profile with the given profile name and email in parameter
     * @param Member selecteMember
     * @return  List<Profile> all the profiles under the given member
     */
    public List<Profile> getProfiles(String email);

    /**
     * getProfile
     * @param email String
     * @param profileName String
     * @return Profile
     */
    public Profile getProfile (String email, String profileName);

    /**
     * updateProfile
     * @param newProfile Profile object
     * @return Profile
     */
    public Profile updateProfile(Profile newProfile);

    /**
     * updateProfileName
     * @param profile Profile object
     * @param newName String
     * @return Profile
     */
    public Profile updateProfileName (Profile profile, String newName) throws NameExistsException;

}