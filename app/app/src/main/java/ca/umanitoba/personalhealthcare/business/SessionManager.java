package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Profile;

/**
 * Design pattern: Singleton
 */

public interface SessionManager {
    public LoginSession retrieveSession ();
    public void saveSessionMember (Member member);
    public void saveSessionProfile (Profile selectedProfile);
    public void restartExpiredTime ();
}
