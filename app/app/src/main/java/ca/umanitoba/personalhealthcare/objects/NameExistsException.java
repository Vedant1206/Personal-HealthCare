package ca.umanitoba.personalhealthcare.objects;
/**
 * The custom exception for name exists
 * one email multiple name(profile) but no duplicate name
 */
public class NameExistsException extends Exception {

    public NameExistsException() {super("Name has already been used!");}
    public NameExistsException(String message){super(message);}
}