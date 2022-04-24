package ca.umanitoba.personalhealthcare.objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class ConditionSymptomsTest {

    @Test
    public void testCreation(){
        System.out.println("\nStarting ConditionSymptom object creation test");

        Condition condition =new Condition("Cancer", "Wikipedia", "https://en.wikipedia.org/wiki/Cancer", "");
        Symptom symptom1 = new Symptom("Blurry vision", "Head");
        Symptom symptom2 = new Symptom("Hairy chest", "Chest");
        ArrayList<Symptom> symptomList = new ArrayList<>();
        symptomList.add(symptom1);
        symptomList.add(symptom2);
        Boolean isCommon = false;

        ConditionSymptoms conditionSymptom = new ConditionSymptoms(condition, symptomList, isCommon);

        assertNotNull(conditionSymptom);

        assertTrue("Condition name should be Cancer", "Cancer".equals(conditionSymptom.getCondition().getName()) );
        assertTrue("Condition sourceName should be Wikipedia", "Wikipedia".equals(conditionSymptom.getCondition().getSourceName()) );
        assertTrue("Condition Link should be wikipedia link", "https://en.wikipedia.org/wiki/Cancer".equals(conditionSymptom.getCondition().getSourceLink()) );
        assertFalse("isCommonDisease should be False", conditionSymptom.isCommonDisease());
        assertTrue("Symptom1 name should be Blurry vision", "Blurry vision".equals(conditionSymptom.getSymptoms().get(0).getSymptomName()) );
        assertTrue("Symptom1 BodyPart should be Head", "Head".equals(conditionSymptom.getSymptoms().get(0).getBodyPart()) );
        assertTrue("Symptom1 toString() should return its name", "Blurry vision".equals(conditionSymptom.getSymptoms().get(0).toString()) );
        assertTrue("Symptom2 name should be Hairy Chest", "Hairy chest".equals(conditionSymptom.getSymptoms().get(1).getSymptomName()) );
        assertTrue("Symptom2 BodyPart should be Chest", "Chest".equals(conditionSymptom.getSymptoms().get(1).getBodyPart()) );
        assertTrue("Symptom2 toString() should return its name", "Hairy chest".equals(conditionSymptom.getSymptoms().get(1).toString()) );


        System.out.println("Finished testCreation");
    }

}
