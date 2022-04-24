package ca.umanitoba.personalhealthcare.persistence;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;

public class MemberPersistenceTest {
    private static final int SAMPLE_SIZE = 10;
    MemberPersistence persistence;
    Member[] sampleMembers;
    String email;
    String password;

    @Before
    public void setup () {
        email = "random@email.com";
        password = "P@ssword123!";

        persistence = FakeMemberPersistence.getMemberPersistence();

        sampleMembers = new Member[SAMPLE_SIZE];
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            try {
                sampleMembers[i] = new Patient(i+"", i+email, password);
            } catch (EmailInvalidException e) {
                assertTrue(false);
            } catch (PasswordInvalidException e) {
                assertTrue(false);
            }
            try {
                persistence.createMember(sampleMembers[i]);
            } catch (EmailExistException e) {
                e.printStackTrace();
                assertTrue(false);
            }
        }


    }

    @After
    public void clean () {

    }

    @Test
    public void testGetMember () {

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            String emailToGet = sampleMembers[i].getEmail();
            Member member = persistence.getMember(emailToGet, password);
            Assert.assertNotNull(member);
        }
    }
}
