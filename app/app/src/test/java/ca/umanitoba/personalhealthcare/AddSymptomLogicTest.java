package ca.umanitoba.personalhealthcare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.umanitoba.personalhealthcare.business.AddSymptomLogic;
import ca.umanitoba.personalhealthcare.business.AddSymptomLogicImp;

class AddSymptomLogicTest {

    AddSymptomLogic addSymptomLogic;
    String name = "Symptom";
    String c1 = "Condition1";
    String c2 = "Condition2";
    String c3 = "Condition3";
    Boolean head = true;
    Boolean chest = false;
    Boolean stomach = true;
    Boolean everywhere = false;

    @Before
    public void setup() {

        addSymptomLogic = new AddSymptomLogicImp(name, c1, c2, c3, head, chest, stomach, everywhere);

    }

    @Test
    public void testString() {
        assertEquals(addSymptomLogic.getSymptomString(), name + ":\nAffected body parts: [head, chest]"
                + "\nAssociated conditions: [Condition1, Condition2, Condition3]" + "\n");

    }

}
