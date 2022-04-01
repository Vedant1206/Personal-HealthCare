package ca.umanitoba.personalhealthcare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.business.SearchActivityLogic;
import ca.umanitoba.personalhealthcare.business.SearchActivityLogicImp;

class SearchActivityLogicTest {

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