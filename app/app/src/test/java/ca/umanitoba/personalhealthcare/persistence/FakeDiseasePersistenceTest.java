package ca.umanitoba.personalhealthcare.persistence;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.business.AddSymptomLogicImp;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;

public class FakeDiseasePersistenceTest {
    private DiseasePersistence fakeDb;

    @Before
    public void testCreation(){
        fakeDb = new FakeDiseasePersistence();

        assertNotNull(fakeDb);
    }

    @Test
    public void testCommonConditions(){
        boolean contains;

        System.out.println("\nStarting testCommonConditions in FakeDiseaseDB");

        Condition pms = new Condition("PMS", "WebMD", "https://www.webmd.com/women/pms/features/pms-signs-symptoms");
        Condition arthritis = new Condition("Arthritis", "MedlinePlus", "https://medlineplus.gov/ency/article/001243.htm");

        ArrayList<Condition> conditionList = fakeDb.getCommonConditions();
        assertNotNull(conditionList);

        contains = false;
        for(Condition c : conditionList){
            if(c.equals(pms)){
                contains = true;
                break;
            }
        }
        assertTrue("PMS should be in common conditions", contains);

        //redoing the loop test but on different input
        contains = false;
        for(Condition c : conditionList){
            if(c.equals(arthritis)){
                contains = true;
                break;
            }
        }
        assertTrue("Arthritis should not be in common conditions", contains);


        System.out.println("\nFinished testCommonConditions in FakeDiseaseDB");
    }

    @Test
    public void testSymptomsByBodyParts(){
        System.out.println("\nStarting testSymptomsByBodyParts in FakeDiseaseDB");

        boolean contains;

        assertTrue("Symptoms list for butt should be empty because its not a bodypart in our db yet", fakeDb.getSymptomsByBodyPart("butt").size()==0);

        ArrayList<Symptom> headSymptoms = fakeDb.getSymptomsByBodyPart("head");
        //whitebox testing because we know symptoms should be compared with ignore case
        ArrayList<Symptom> headSymptoms2 = fakeDb.getSymptomsByBodyPart("HeAd");

        assertNotNull("Symptoms list for head should not be null", headSymptoms);
        assertNotNull("Symptoms list for head2 should not be null", headSymptoms2);

        assertTrue("Sizes of both headSymptoms lists should be same", headSymptoms.size()==headSymptoms2.size());

            contains = false;

        for(Symptom s1 : headSymptoms){
            if(headSymptoms2.contains(s1)) contains = true;
        }
        assertTrue("all Symptom from headSymptoms2 should be present in headSymptoms1", contains);

        System.out.println("\nFinished testSymptomsByBodyParts in FakeDiseaseDB");
    }


}
