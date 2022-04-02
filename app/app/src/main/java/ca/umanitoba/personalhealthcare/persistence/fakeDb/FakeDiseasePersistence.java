package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.ConditionSymptoms;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;


/**
 * This is a Fake data set where we are storing the data about each symptom
 * This class implements an instance class called Disease persistence class
 */
public class FakeDiseasePersistence implements DiseasePersistence {

    //storing the data here
    private ArrayList<ConditionSymptoms> conditionsDB;

    public FakeDiseasePersistence() {
        initializeData();
    }

    private void initializeData(){
        conditionsDB = new ArrayList<ConditionSymptoms>();

        //initializing Conditions with their metadata
        Condition acne = new Condition("Acne", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/acne/symptoms-causes/syc-20368047");
        Condition gerd = new Condition("Acid Reflux (GERD)", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/gerd/symptoms-causes/syc-20361940");
        Condition hangover = new Condition("Hangover", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/hangovers/symptoms-causes/syc-20373012");
        Condition anemia = new Condition("Anemia", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/anemia/symptoms-causes/syc-20351360");
        Condition cold = new Condition("Cold", "WebMD", "https://www.webmd.com/cold-and-flu/features/cold-sinus-infections");
        Condition pms = new Condition("PMS", "WebMD", "https://www.webmd.com/women/pms/features/pms-signs-symptoms");
        Condition chalazion = new Condition("Chalazion", "MedlinePlus", "https://medlineplus.gov/ency/article/001006.htm");
        Condition arthritis = new Condition("Arthritis", "MedlinePlus", "https://medlineplus.gov/ency/article/001243.htm");

        // creating symptom list
        ArrayList<Symptom> acneSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> gerdSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> hangoverSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> anemiaSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> coldSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> pmsSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> chalazionSymp = new ArrayList<Symptom>();
        ArrayList<Symptom> arthritisSymp = new ArrayList<Symptom>();

        // initializing symptom list
        acneSymp.add(new Symptom("Whiteheads", "head"));
        acneSymp.add(new Symptom("Blackheads", "head"));
        acneSymp.add(new Symptom("Small bumps", "head"));
        acneSymp.add(new Symptom("Pimples", "head"));

        gerdSymp.add(new Symptom("Heartburn", "chest"));
        gerdSymp.add(new Symptom("Chest pain", "chest"));
        gerdSymp.add(new Symptom("Difficulty swallowing", "chest"));

        hangoverSymp.add(new Symptom("Fatigue", "chest"));
        hangoverSymp.add(new Symptom("Excessive thirst", "stomach"));
        hangoverSymp.add(new Symptom("Nausea", "head"));
        hangoverSymp.add(new Symptom("Headache", "head"));
        hangoverSymp.add(new Symptom("Shakiness", "chest"));

        anemiaSymp.add(new Symptom("Fatigue", "chest"));
        anemiaSymp.add(new Symptom("Weakness", "head"));
        anemiaSymp.add(new Symptom("Pale skin", "chest"));
        anemiaSymp.add(new Symptom("Cold hands", "arms"));
        anemiaSymp.add(new Symptom("Dizziness", "head"));

        coldSymp.add(new Symptom("Sore throat", "head"));
        coldSymp.add(new Symptom("Stuffy nose", "head"));
        coldSymp.add(new Symptom("Swollen sinuses", "head"));
        coldSymp.add(new Symptom("Fatigue", "chest"));
        coldSymp.add(new Symptom("Headache", "head"));
        coldSymp.add(new Symptom("Sneezing", "head"));

        pmsSymp.add(new Symptom("Moodiness", "stomach"));
        pmsSymp.add(new Symptom("Abdominal cramping", "stomach"));
        pmsSymp.add(new Symptom("Food cravings", "stomach"));
        pmsSymp.add(new Symptom("Bloating", "stomach"));
        pmsSymp.add(new Symptom("Breast tenderness", "chest"));

        chalazionSymp.add(new Symptom("Bump on eyelid", "head"));
        chalazionSymp.add(new Symptom("Eye irritation", "head"));
        chalazionSymp.add(new Symptom("Blurry vision", "head"));

        arthritisSymp.add(new Symptom("Joint pain", "arms"));
        arthritisSymp.add(new Symptom("Joint swelling", "arms"));
        arthritisSymp.add(new Symptom("Joint stiffness", "arms"));

        //connecting both objects with more metadata
        conditionsDB.add(new ConditionSymptoms(acne, acneSymp,true));
        conditionsDB.add(new ConditionSymptoms(gerd, gerdSymp,false));
        conditionsDB.add(new ConditionSymptoms(hangover, hangoverSymp, true));
        conditionsDB.add(new ConditionSymptoms(anemia, anemiaSymp, true));
        conditionsDB.add(new ConditionSymptoms(cold, coldSymp, true));
        conditionsDB.add(new ConditionSymptoms(pms, pmsSymp, true));
        conditionsDB.add(new ConditionSymptoms(chalazion, chalazionSymp,true));
        conditionsDB.add(new ConditionSymptoms(arthritis, arthritisSymp, true));
    }

    @Override
    public ArrayList<Condition> getCommonConditions() {
        ArrayList<Condition> commonConditions = new ArrayList<Condition>();

        for (ConditionSymptoms c : conditionsDB) {
            if(c.isCommonDisease())
                commonConditions.add(c.getCondition());
        }

        return commonConditions;
    }

    @Override
    //returns the symptom according to body part
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart) {
        ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
        for (ConditionSymptoms c : conditionsDB) {
            for(Symptom symp : c.getSymptoms()){
                if(symp.getBodyPart().equalsIgnoreCase(bodyPart))
                    symptoms.add(symp);
            }
        }
        return symptoms;
    }

    /*
        We have coded it such that if the input symptoms match over 25% of the real symptoms in database
        then we add it to the output Conditions list
     */
    @Override
    public ArrayList<Condition> getConditionsBySymptoms(ArrayList<Symptom> inputSymptoms) {

        int symptCounter;
        ArrayList<Condition> conditions = new ArrayList<Condition>();

        for (ConditionSymptoms c : conditionsDB) {
            symptCounter = 0;

            //prelim check of length, so if the input symptoms from the getgo are not long enough then we ignore them
            if(inputSymptoms.size() >= c.getSymptoms().size()/4){
                for(Symptom s : c.getSymptoms()){
                    if(inputSymptoms.contains(s))
                        symptCounter++;
                }

                if(symptCounter >= c.getSymptoms().size()/4)
                    conditions.add(c.getCondition());
            }

        }

        return conditions;
    }

}