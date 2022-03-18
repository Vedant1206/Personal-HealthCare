package ca.umanitoba.personalhealthcare.objects;

public class PasswordInvalidException extends Exception {
    public PasswordInvalidException() {
        super("Password must be less than 20 and more than 8 characters in length.\n" +
                "Password must have at least one uppercase character\n" +
                "Password must have at least one lowercase character\n" +
                "Password must have at least one number\n" +
                "Password must have at least one special character among @#$%");
    }

    public PasswordInvalidException(String message) {
        super(message);
    }
}
