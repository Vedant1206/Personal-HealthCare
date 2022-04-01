package ca.umanitoba.personalhealthcare.objects;

public class NameExistsException extends Exception {

    public NameExistsException() {super("Name has already been used!");}
    public NameExistsException(String message){super(message);}
}