package ca.umanitoba.personalhealthcare.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.objects.Condition;

public class ResultsLogicTest {

    ResultsLogic resultsLogic;
    Condition returnedCondition;

    @Before
    public void setup() {

        resultsLogic = new ResultsLogicImp();
        returnedCondition = resultsLogic.getCondition();

    }

    @Test
    public void testCondition() {

        assertNotNull(returnedCondition);

    }

}