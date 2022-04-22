package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistence;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistenceImp;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;

public class AccountManagerImp implements  AccountManager {
    MemberPersistence memberPersistence;
    LoginSessionPersistence loginSessionPersistence;

    public AccountManagerImp() {
        memberPersistence = FakeMemberPersistence.getMemberPersistence(); //TODO: create a fake persistence
        loginSessionPersistence =  LoginSessionPersistenceImp.getLoginSessionPersistence();
    }

    public AccountManagerImp(MemberPersistence memberPersistence) {
        this.memberPersistence = memberPersistence;
    }

    @Override
    public LoginSession authMemberLogin(String username, String password) {
        Member member = memberPersistence.getMember(username, password);
        LoginSession session = loginSessionPersistence.getLoginSession();
        session.setLogined(member != null);
        session.setMemberEmail(username);

        loginSessionPersistence.saveLoginSession(session);
        return session;
    }

    @Override
    public Member createAccount(String email, String password) throws PasswordInvalidException, EmailInvalidException, EmailExistException {
        Member newMember = new Patient(null, email, password);
        System.out.println("Create : " + email + " - " + password);

        Member createdMember = memberPersistence.createMember(newMember);

        return createdMember;
    }
}
