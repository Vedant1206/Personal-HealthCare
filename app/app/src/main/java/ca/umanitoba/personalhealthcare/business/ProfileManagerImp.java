package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

public class ProfileManagerImp implements ProfileManager{
    //TODO: Refactor after loginsession add
    MemberPersistence memberPersistence;
    Patient selectedPatient;
    //___________________________________
    ProfilePersistence profiles;

    /**
     * The constructor for ProfileManagerImp
     * @param email
     * @param password
     */
    public ProfileManagerImp(String email, String password){
        //------------------------------Area need be rework
        memberPersistence = FakeMemberPersistence.getMemberPersistence();
        Member selectedMember = memberPersistence.getMember(email, password);
        if(selectedMember instanceof Patient){
            selectedPatient = (Patient)selectedMember;
            // Maybe need to refactor if the Doctor class is implement.
        }
        //TODO: create a fake persistence
        //------------------------------Area need be rework
        //TODO: Refactor the constructor after the LoginSession create.
        profiles = FakeProfilePersistence.getProfilePersistence();

    }

    @Override
    public Profile createProfile(Profile newProfile) {
        if(newProfile.getEmail() == null){
            newProfile.setEmail(selectedPatient.getEmail());
            //TODO: Need to be fix when we add the LoginSession.
        }
        boolean checking = profiles.checkProfile(newProfile.getEmail(), newProfile.getName());
        if(checking = true){
            return null;
        }
        try {
            profiles.createProfile(newProfile);
        } catch (NameExistsException | EmailExistException e) {
            e.printStackTrace();
        }
        return newProfile;

    }

    @Override
    public boolean deleteProfile(String email, String profileName){
        boolean deleted = true;
        if(profiles.deleteProfile(email, profileName)){
            return deleted;
        }
        return !deleted;
    }

    @Override
    public Profile getProfile(String email, String profileName){
        Profile lookingFor = profiles.getProfile(email, profileName);
        return lookingFor;
    }


}
