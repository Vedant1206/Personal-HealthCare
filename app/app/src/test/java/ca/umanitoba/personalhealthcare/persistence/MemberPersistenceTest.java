package ca.umanitoba.personalhealthcare.persistence;

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
    MemberPersistence persistence;

    @Before
    public void setup () {
        persistence = FakeMemberPersistence.getMemberPersistence();
    }

    @Test
    public void testCreateMember () {

        try {
            persistence.createMember(new Patient("1", "randomEmail@gmail.com", "P@ssword123!"));
        } catch (EmailExistException e) {
            e.printStackTrace();
        } catch (EmailInvalidException e) {
            e.printStackTrace();
            return;
        } catch (PasswordInvalidException e) {
            e.printStackTrace();
            return;
        }

        Member member = persistence.getMember("randomEmail@gmail.com", "P@ssword123!");
        Assert.assertNotNull(member);
    }
}
