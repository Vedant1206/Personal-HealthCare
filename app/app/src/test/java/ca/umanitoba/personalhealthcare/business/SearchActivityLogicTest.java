package ca.umanitoba.personalhealthcare.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchActivityLogicTest {

    SearchActivityLogic searchActivityLogic;
    String[] commonConditions;

    @Before
    public void setup() {

        searchActivityLogic = new SearchActivityLogicImp();
        commonConditions = searchActivityLogic.getCommonConditions();

    }

    @Test
    public void testConditions() {

        assertNotNull(commonConditions);

    }

}