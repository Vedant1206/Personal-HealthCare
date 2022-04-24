package ca.umanitoba.personalhealthcare.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultsLogicTest {

    ResultsLogic resultsLogic;

    @Before
    public void setup() {

        resultsLogic = new ResultsLogicImp();

    }

    @Test
    public void testCondition() {

        assertNotNull(resultsLogic.getConditionName());
        assertNotNull(resultsLogic.getConditionSourceName());
        assertNotNull(resultsLogic.getConditionSourceLink());
        assertNotNull(resultsLogic.getConditionDescription());

    }

}