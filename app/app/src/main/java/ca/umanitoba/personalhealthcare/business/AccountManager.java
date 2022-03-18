package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;

public interface AccountManager {

    // Access to persistence to check if authentication is succeed
    public boolean authMemberLogin(String username, String password);

    /**
     * Given email, password to create a new member/account
     *
     * @param email
     * @param password
     * @return new member object        new created member with an id
     * @throws PasswordInvalidException password format is invalid
     * @throws EmailInvalidException    email format is invalid
     * @throws EmailExistException      email was used for another account
     * @see Member                      about the required format of password
     * @see Member                      about the required format of email
     */
    public Member createAccount(String email, String password)
            throws PasswordInvalidException, EmailInvalidException, EmailExistException;

}
