
package ca.umanitoba.personalhealthcare.objects;

import java.util.regex.Pattern;

public abstract class Member extends User {
    protected String email;
    protected String password;

    public Member(String id) {
        super(id);
    }

    public Member(String id, String email, String password) throws PasswordInvalidException, EmailInvalidException {
        super(id);
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailInvalidException {
        if (!isEmailAcceptable(email)) {
            throw new EmailInvalidException();
        }
        this.email = email;
    }

    private boolean isEmailAcceptable(String email) {
        if (email == null) {
            return false;
        }
        //Source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) throws PasswordInvalidException {
        if (isPasswordAcceptable(password)) {
            this.password = password;
        }
    }

    private boolean isPasswordAcceptable(String password) throws PasswordInvalidException {
        if (password.length() > 15 || password.length() < 8) {
            throw new PasswordInvalidException("Password must be less than 20 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            throw new PasswordInvalidException("Password must have at least one uppercase character");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            throw new PasswordInvalidException("Password must have at least one lowercase character");
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            throw new PasswordInvalidException("Password must have at least one number");
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            throw new PasswordInvalidException("Password must have at least one special character among @#$%");
        }
        return true;
    }

    // password Checking
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
