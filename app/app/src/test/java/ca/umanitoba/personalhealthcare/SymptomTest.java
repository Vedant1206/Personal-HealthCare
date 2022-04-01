package ca.umanitoba.personalhealthcare;
import static org.junit.Assert.*;

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


        System.out.println("Finished testCreation");
    }

    @Test
    public void testEquals(){
        System.out.println("\nStarting Symptom equals() test");

        Symptom sym1 = new Symptom("Blurry vision", "Head");
        Symptom sym2 = new Symptom("Blurry vision", "Legs");
        Symptom sym3 = new Symptom("Headache", "Head");

        assertTrue("Checking if Blurry vision equals Blurry vision", sym1.equals(new Symptom("Blurry vision", "Head")) );
        assertFalse("Both symptoms bodyParts are different, should not be equal", sym2.equals(sym1) );
        assertFalse("Both symptoms names are different, should not be equal", sym1.equals(sym3) );

        System.out.println("Finished testEquals");
    }

}
