package ca.umanitoba.personalhealthcare.business;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;

public class AccountManagerTest {
    AccountManager accountManager;

    @Before
    public void setup () {
        accountManager = new AccountManagerImp(FakeMemberPersistence.getMemberPersistence());
    }

    @Test()
    public void testCreateAccountEmailInvalid () {
        assertThrows(EmailInvalidException.class, () -> accountManager.createAccount("comp3350","P@sword123!"));
    }

    @Test()
    public void testCreateAccountPasswordInvalid () {
        //Length: Less than 8
        assertThrows(PasswordInvalidException.class, () -> accountManager.createAccount("comp3350@umanitoba.ca", "P@s13!"));
        //No lowercase
        assertThrows(PasswordInvalidException.class, () -> accountManager.createAccount("comp3350@umanitoba.ca", "P@SSWORD123!"));
        //No number
        assertThrows(PasswordInvalidException.class, () -> accountManager.createAccount("comp3350@umanitoba.ca", "P@sssword!"));
        //No upper case
        assertThrows(PasswordInvalidException.class, () -> accountManager.createAccount("comp3350@umanitoba.ca", "p@sssword!"));
        //No special character
        assertThrows(PasswordInvalidException.class, () -> accountManager.createAccount("comp3350@umanitoba.ca", "P@sssword"));

        try {
            accountManager.createAccount("comp3350@umanitoba.ca", "P@sssword123!");
        } catch (Exception e) {
            //If throw -> error
            assertNotEquals(1, 1);
        }
    }

    @Test
    public void testCreateAccountExistingEmail () {
        try {
            accountManager.createAccount("comp3350A1@umanitoba.ca", "P@sssword123!");
        } catch (Exception e) {
            //If throw -> error
            assertNotEquals(1, 1);
        }

        assertThrows(EmailExistException.class, () -> accountManager.createAccount("comp3350A1@umanitoba.ca", "P@ssssss123!"));


    }

    @Test
    public void testCreateAccountReturnMemberWithID () {
        try {
            Member newMem = accountManager.createAccount("comp3350G1@umanitoba.ca", "P@sssword123!");
            assertNotNull(newMem.getID());
        } catch (Exception e) {
            //If throw -> error
            e.printStackTrace();
            assertNotEquals(1, 1);
        }
    }
}
