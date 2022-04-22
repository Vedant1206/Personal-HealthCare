package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.LoginSession;

public interface LoginSessionPersistence {
    LoginSession getLoginSession();

    void saveLoginSession(LoginSession session);
}
