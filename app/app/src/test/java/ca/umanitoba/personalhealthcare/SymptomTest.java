package ca.umanitoba.personalhealthcare;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.umanitoba.personalhealthcare.objects.Symptom;

public class SymptomTest {

    @Test
    public void testCreation(){
        System.out.println("\nStarting Symptom object creation test");

        Symptom sym = new Symptom("Blurry vision", "Head");

        assertNotNull(sym);

        assertTrue("Symptom name should be Blurry vision", "Blurry vision".equals(sym.getSymptomName()) );
        assertTrue("BodyPart should be Blurry vision", "Head".equals(sym.getBodyPart()) );
        assertTrue("Symptom toString() should return its name", "Blurry vision".equals(sym) );


        System.out.println("Finished testSC");
    }

}
