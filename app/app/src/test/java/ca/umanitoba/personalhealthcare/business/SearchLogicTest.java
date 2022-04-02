package ca.umanitoba.personalhealthcare.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchLogicTest {

    SearchLogic searchLogic;
    String[] commonConditions;

    @Before
    public void setup() {

        searchLogic = new SearchLogicImp();
        commonConditions = searchLogic.getCommonConditions();

    }

    @Test
    public void testConditions() {

        assertNotNull(commonConditions);

    }

}