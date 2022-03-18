package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;

public class AccountManagerImp implements  AccountManager {
    MemberPersistence memberPersistence;

    public AccountManagerImp() {
        memberPersistence = FakeMemberPersistence.getMemberPersistence(); //TODO: create a fake persistence
    }

    public AccountManagerImp(MemberPersistence memberPersistence) {
        this.memberPersistence = memberPersistence;
    }

    @Override
    public boolean authMemberLogin(String username, String password) {
        //TODO: to be implemented
        return false;
    }

    @Override
    public Member createAccount(String email, String password) throws PasswordInvalidException, EmailInvalidException, EmailExistException {
        Member newMember = new Patient(null, email, password);

        Member createdMember = memberPersistence.createMember(newMember);

        return createdMember;
    }
}
