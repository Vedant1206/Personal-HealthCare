package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Member;
import java.util.List;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;

public interface ProfilePersistence{

    Profile insertProfile(Profile currentProfile);
    Profile updateProfile(Profile currentProfile);
    void deleteProfile(Profile currentProfile);
    List<Profile> getProfile(Member currentMember);

}
