package ca.umanitoba.personalhealthcare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ca.umanitoba.personalhealthcare.business.ProfileManagerIntTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProfileManagerIntTest.class
})
public class IntegrationTests {
}
