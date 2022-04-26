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

public class DiseasePersistenceTest {
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

        Condition pms = new Condition("PMS", "WebMD", "https://www.webmd.com/women/pms/features/pms-signs-symptoms", "");
        Condition arthritis = new Condition("Arthritis", "MedlinePlus", "https://medlineplus.gov/ency/article/001243.htm", "");

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

    @Test
    public void testConditionsBySymptoms(){

        ArrayList<Condition> conditions = new ArrayList<>();

        //expected result conditions
        Condition anemia = new Condition("Anemia", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/anemia/symptoms-causes/syc-20351360", "Anemia is a condition in which you lack enough healthy red blood cells to carry adequate oxygen to your body's tissues. Having anemia, also referred to as low hemoglobin, can make you feel tired and weak.<br>There are many forms of anemia, each with its own cause. Anemia can be temporary or long term and can range from mild to severe. In most cases, anemia has more than one cause. See your doctor if you suspect that you have anemia. It can be a warning sign of serious illness.<br>");
        Condition cold = new Condition("Cold", "WebMD", "https://www.webmd.com/cold-and-flu/features/cold-sinus-infections", "If it’s a cold virus, you may find yourself close to a tissue box for several days. Most of the time, colds get better on their own in 10 days or less.<br>Because the common cold is a virus, antibiotics won’t help. But over-the-counter medications may make you feel better.<br>“The remedies you choose should be targeted at specific symptoms, so something for your headache, for your congestion, for your fever,” says Camelia Davtyan, MD, a professor of medicine at UCLA.<br>");
        Condition chalazion = new Condition("Chalazion", "MedlinePlus", "https://medlineplus.gov/ency/article/001006.htm", "A chalazion is a small bump in the eyelid caused by a blockage of a tiny oil gland.<br>A chalazion often develops following an internal hordeolum (also called a stye). The eyelid most often becomes tender, red, swollen and warm. Sometimes, the blocked gland causing the stye will not drain even though the redness and swelling go away. The gland will form a firm nodule in the eyelid that is not tender. This is called a chalazion.<br>");
        Condition gerd = new Condition("Acid Reflux (GERD)", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/gerd/symptoms-causes/syc-20361940", "Gastroesophageal reflux disease (GERD) occurs when stomach acid frequently flows back into the tube connecting your mouth and stomach (esophagus). This backwash (acid reflux) can irritate the lining of your esophagus.<br>Many people experience acid reflux from time to time. GERD is mild acid reflux that occurs at least twice a week, or moderate to severe acid reflux that occurs at least once a week.<br>");
        Condition pms = new Condition("PMS", "WebMD", "https://www.webmd.com/women/pms/features/pms-signs-symptoms", "PMS affects almost all women to some degree during their reproductive years. <br>PMS is a catch-all name for a myriad of physical and psychological symptoms, it is thought to be caused by hormonal changes during the menstrual cycle. The exact cause, however, remains a mystery. Symptoms generally strike five-to-10 days before the period and dissipate with its start or soon after. Research has determined that women are not imagining anything -- and, thankfully, there is help.<br>");


        ArrayList<Symptom> symptoms = new ArrayList<>();

        //adding symptoms only pertaining to one body part, thats how the app will call them
        symptoms.add(new Symptom("Stuffy nose", "head"));
        symptoms.add(new Symptom("Blurry vision", "head"));
        symptoms.add(new Symptom("Weakness", "head"));

        //but throwing in another symptom from another bodypart to test the robustness of the method
        //Note however, the method we are testing will never have to take Symptom inputs from multiple bodyparts at once
        symptoms.add(new Symptom("Bloating", "stomach"));
        symptoms.add(new Symptom("Heartburn", "chest"));


        conditions = fakeDb.getConditionBySymptoms(symptoms);

        assertTrue("Output conditions list should contain Anemia", conditions.contains(anemia));
        assertTrue("Output conditions list should contain Chalazion", conditions.contains(chalazion));
        assertTrue("Output conditions list should contain Cold", conditions.contains(cold));
        assertTrue("Output conditions list should contain GERD", conditions.contains(gerd));
        assertTrue("Output conditions list should contain PMS", conditions.contains(pms));
    }


}
