package ca.umanitoba.personalhealthcare.objects;

public class EmailInvalidException extends Exception{
    public EmailInvalidException() {
        super("Email has invalid format!");
    }

    public EmailInvalidException(String message) {
        super(message);
    }
}
