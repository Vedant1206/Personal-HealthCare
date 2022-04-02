package ca.umanitoba.personalhealthcare.objects;

public class Patient extends Member {
    /**
     * This is default constructor for Patient where you create Patient
     *
     * @param id
     * @param email
     * @param password
     */
    public Patient(String id, String email, String password) throws EmailInvalidException, PasswordInvalidException {
        super(id, email, password);
    }







}
