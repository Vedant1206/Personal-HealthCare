package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import java.util.List;

import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public interface ProfilePersistence{
    /**
     * The method to insert the given Profile object to the data.
     * @param currentProfile The new profile need to be store
     * @return Profile the return the profile object that been inserted
     *                 the return of the method can be change later on.
     *
     */
    Profile insertProfile(Profile currentProfile) throws NameExistsException;

    /**
     * The method to update the given Profile object inside the data.
     * @param currentProfile
     * @return Profile Return the profile object that been updated
     *                 the return of the method can be change later on.
     */
    Profile updateProfile(Profile currentProfile);

    /**
     * The method to delete the given Profile from the data
     * @param currentProfile the profile object that will be delete
     *
     */
    void deleteProfile(Profile currentProfile);

    /**
     * The method to return all the profiles under given member
     * @param currentMember
     * @return List<Profile> The list of the profile under the given member.
     */
    List<Profile> getProfiles(String email);

    Profile getProfile (String email, String profileName);

    Profile updateProfileName (Profile profile, String initName) throws NameExistsException;

}
