package ca.umanitoba.personalhealthcare.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BodyPartsLogicTest {

    BodyPartsLogic bodyPartsLogic;
    String bodyPart;

    @Before
    public void setup() {

        bodyPart = "head";
        bodyPartsLogic = new BodyPartsLogicImp(bodyPart);

    }

    @Test
    public void testName() {

        assertEquals(bodyPartsLogic.getName(), "head");

    }

    @Test
    public void testSymptoms() {

        assertNotNull(bodyPartsLogic.getSymptoms());

    }

}
