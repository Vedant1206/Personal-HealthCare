package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public interface ProfilePersistence{
    public Profile getProfile(String email, String profileName);
    public boolean createProfile(Profile newProfile) throws NameExistsException, EmailExistException;
    public boolean deleteProfile(String email, String profileName);
    public boolean checkProfile(String);
}
