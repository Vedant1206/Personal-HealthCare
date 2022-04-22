package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.LoginSession;

public class LoginSessionPersistenceImp implements LoginSessionPersistence {
    private LoginSession session;
    private static LoginSessionPersistenceImp loginSessionPersistenceImp;
    public static LoginSessionPersistenceImp getLoginSessionPersistence () {
        if (loginSessionPersistenceImp == null) {
            loginSessionPersistenceImp = new LoginSessionPersistenceImp();
        }
        return loginSessionPersistenceImp;
    }

    private LoginSessionPersistenceImp() {
        session = new LoginSession();
        session.setLogined(false);
    }

    @Override
    public LoginSession getLoginSession() {
        return session;
    }

    @Override
    public void saveLoginSession(LoginSession session) {
        session = session;
    }
}
