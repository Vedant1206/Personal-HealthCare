package ca.umanitoba.personalhealthcare;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ca.umanitoba.personalhealthcare.business.AccountManagerTest;
import ca.umanitoba.personalhealthcare.business.AddSymptomLogic;
import ca.umanitoba.personalhealthcare.business.AddSymptomLogicTest;
import ca.umanitoba.personalhealthcare.business.BodyPartsLogicTest;
import ca.umanitoba.personalhealthcare.business.ProfileManagerUnitTest;
import ca.umanitoba.personalhealthcare.business.SearchLogicTest;
import ca.umanitoba.personalhealthcare.objects.ConditionSymptomsTest;
import ca.umanitoba.personalhealthcare.objects.ConditionTest;
import ca.umanitoba.personalhealthcare.objects.SymptomTest;
import ca.umanitoba.personalhealthcare.persistence.FakeDiseasePersistenceTest;
import ca.umanitoba.personalhealthcare.persistence.database.ConnectionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountManagerTest.class,
        AddSymptomLogicTest.class,
        BodyPartsLogicTest.class,
        ProfileManagerUnitTest.class,
        SearchLogicTest.class,
        ConditionSymptomsTest.class,
        ConditionTest.class,
        SymptomTest.class,
        FakeDiseasePersistenceTest.class
})
public class AllTests
{

}
