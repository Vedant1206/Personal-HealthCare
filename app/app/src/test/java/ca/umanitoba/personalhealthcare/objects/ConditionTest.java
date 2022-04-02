package ca.umanitoba.personalhealthcare.objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConditionTest {

    @Test
    public void testCreation(){
        System.out.println("\nStarting Condition object creation test");

        Condition con = new Condition("Cancer", "Wikipedia", "https://en.wikipedia.org/wiki/Cancer");

        assertNotNull(con);

        assertTrue("Condition name should be Cancer", "Cancer".equals(con.getName()) );
        assertTrue("SourceName should be Wikipedia", "Wikipedia".equals(con.getSourceName()) );
        assertTrue("SourceLink should return https://en.wikipedia.org/wiki/Cancer", "https://en.wikipedia.org/wiki/Cancer".equals(con.getSourceLink()) );


        System.out.println("Finished testCreation");
    }

}
