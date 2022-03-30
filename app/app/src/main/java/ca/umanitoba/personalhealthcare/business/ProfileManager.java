package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Patient;

public interface ProfileManager {

    /**
     * Create new profile
     * The new profile must have a unique name compare to other profiles under same account.
     *
     * @param   profile {Profile}
     * @return  true if the profile has a unique name
     * @return  false if the profile has a same name as one in the list, profile is not added
     */
    public Profile createProfile(Profile newProfile);

    /**
     * Delete the profile with the given profile name and email in parameter
     * @param email
     * @param profileName
     * @return true if successfully delete the profile with given name
     * @reutnr false if fail to delete the profile with given name
     */
    public boolean deleteProfile(String email, String profileName);

    /**
     * Search and get the profile with the given profile name and email in parameter
     * @param   email
     * @param   profileName
     * @return  Profile if there is a profile with a given name
     * @return  null    if there is no profile we need
     */
    public Profile getProfile(String email, String profileName);


}