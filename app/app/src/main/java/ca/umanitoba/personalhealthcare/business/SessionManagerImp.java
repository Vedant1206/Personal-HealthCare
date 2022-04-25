package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistence;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistenceImp;

public class SessionManagerImp implements SessionManager{
    LoginSessionPersistence persistence;

    public SessionManagerImp () {
        persistence = LoginSessionPersistenceImp.getLoginSessionPersistence();
    }

    /**
     * retrieveSession
     * @return LoginSession
     */
    @Override
    public LoginSession retrieveSession() {
        return persistence.getLoginSession();
    }

    /**
     * saveSessionMember
     * @param member Member object
     */
    @Override
    public void saveSessionMember(Member member) {
        LoginSession session = retrieveSession();
        session.setMemberEmail(member.getEmail());
        persistence.saveLoginSession(session);
    }

    /**
     * saveSessionProfile
     * @param selectedProfile Profile object
     */
    @Override
    public void saveSessionProfile(Profile selectedProfile) {
        LoginSession session = retrieveSession();
        session.setProfileName(selectedProfile.getName());
        persistence.saveLoginSession(session);
    }

    @Override
    public void restartExpiredTime() {
        //TODO: to be implemented
    }

    /**
     * logout
     * @return boolean
     */
    @Override
    public boolean logout() {
        LoginSession session = persistence.getLoginSession();
        session.setLogined(false);
        persistence.saveLoginSession(session);
        return session.isLogined();
    }
}
