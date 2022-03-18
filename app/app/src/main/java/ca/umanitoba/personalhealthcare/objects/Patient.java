package ca.umanitoba.personalhealthcare.objects;

import java.util.ArrayList;


public class Patient extends Member {
    ArrayList<Profile> profiles;

    /**
     * This is default constructor for Patient where you create Patient
     *
     * @param id
     * @param email
     * @param password
     */
    public Patient(String id, String email, String password) throws EmailInvalidException, PasswordInvalidException {
        super(id, email, password);
    }


    /**
     * Constructor: default constructor + a set of profiles to be added
     *
     * @param   id
     * @param   email
     * @param   password
     * @param   profiles
     */
    public Patient(String id, String email, String password, Profile... profiles) throws EmailInvalidException, PasswordInvalidException {
        super(id, email, password);
        this.profiles = new ArrayList<Profile>();
        for (Profile profile : profiles) {
            addProfile(profile);
        }
    }


    /**
     * Add profile into the profile list
     * The new profile must have a unique name compare to other profile in the list
     *
     * @param   profile {Profile}
     * @return  true if the profile has a unique name
     * @return  false if the profile has a same name as one in the list, profile is not added
     */
    public boolean addProfile(Profile profile) {
        // Checking if any profile has the same name
        for (Profile existingProfile : this.profiles) {
            if (existingProfile.getName().equals(profile.getName())) {
                return false;
            }
        }
        // Profile is good to be added now
        this.profiles.add(profile);
        return true;
    }

    /**
     * Search and get the profile with the given profile name in parameter
     *
     * @param   profileName
     * @return  Profile if there is a profile with a given name
     * @return  null    if there is no profile we need
     */
    public Profile getProfile (String profileName) {
        for (Profile profile: this.profiles) {
            if (profile.getName().equals(profileName)) {
                return profile;
            }
        }
        return null;

    }

    public boolean deleteProfile(String profileName) {
        Profile profile = getProfile(profileName);
        if (profile != null) {
            profiles.remove(profile);
            return true;
        } else {
            return false;
        }
    }


    public long getNumProfiles() {
        return this.profiles.size();
    }




}
