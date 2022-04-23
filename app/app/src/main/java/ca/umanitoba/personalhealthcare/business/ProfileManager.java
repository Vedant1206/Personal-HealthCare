package ca.umanitoba.personalhealthcare.business;
/**
 * The logic layer class that handle profiles
 * The input of this class method can be change in next iteration.
 */

import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;
import java.util.ArrayList;
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

    public Profile getProfile (String email, String profileName);

    /**
     *
     *
     */
    public Profile updateProfile(Profile newProfile);


}