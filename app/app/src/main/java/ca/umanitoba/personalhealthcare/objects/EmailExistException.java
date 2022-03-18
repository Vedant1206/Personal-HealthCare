package ca.umanitoba.personalhealthcare.objects;

public class EmailExistException extends Exception {
    public EmailExistException() {
        super("Email has already been used!");
    }

    public EmailExistException(String message) {
        super(message);
    }
}
