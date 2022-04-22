package ca.umanitoba.personalhealthcare.objects;

/**
 * Design Patter: Singleton
 * Because there is supposed to be only 1 login session!
 */
public class LoginSession {

    private boolean isLogined;
    private String memberEmail;
    private String profileName;
    private int expiredTime;


    public LoginSession() {
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
