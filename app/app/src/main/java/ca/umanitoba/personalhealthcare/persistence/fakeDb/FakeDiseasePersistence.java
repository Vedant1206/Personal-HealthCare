package ca.umanitoba.personalhealthcare.persistence.fakeDb;

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
        acneSymp.add(new Symptom("Whiteheads"));
        acneSymp.add(new Symptom("Blackheads"));
        acneSymp.add(new Symptom("Small bumps"));
        acneSymp.add(new Symptom("Pimples"));

        gerdSymp.add(new Symptom("Heartburn"));
        gerdSymp.add(new Symptom("Chest pain"));
        gerdSymp.add(new Symptom("Difficulty swallowing"));

        hangoverSymp.add(new Symptom("Fatigue"));
        hangoverSymp.add(new Symptom("Excessive thirst"));
        hangoverSymp.add(new Symptom("Nausea"));
        hangoverSymp.add(new Symptom("Headache"));
        hangoverSymp.add(new Symptom("Shakiness"));

        anemiaSymp.add(new Symptom("Fatigue"));
        anemiaSymp.add(new Symptom("Weakness"));
        anemiaSymp.add(new Symptom("Pale skin"));
        anemiaSymp.add(new Symptom("Cold hands"));
        anemiaSymp.add(new Symptom("Dizziness"));

        coldSymp.add(new Symptom("Sore throat"));
        coldSymp.add(new Symptom("Stuffy nose"));
        coldSymp.add(new Symptom("Swollen sinuses"));
        coldSymp.add(new Symptom("Fatigue"));
        coldSymp.add(new Symptom("Headache"));
        coldSymp.add(new Symptom("Sneezing"));

        pmsSymp.add(new Symptom("Moodiness"));
        pmsSymp.add(new Symptom("Abdominal cramping"));
        pmsSymp.add(new Symptom("Food cravings"));
        pmsSymp.add(new Symptom("Bloating"));
        pmsSymp.add(new Symptom("Breast tenderness"));

        chalazionSymp.add(new Symptom("Bump on eyelid"));
        chalazionSymp.add(new Symptom("Eye irritation"));
        chalazionSymp.add(new Symptom("Blurry vision"));

        arthritisSymp.add(new Symptom("Joint pain"));
        arthritisSymp.add(new Symptom("Joint swelling"));
        arthritisSymp.add(new Symptom("Joint stiffness"));

        //connecting both objects with more metadata
        conditionsDB.add(new ConditionSymptoms(acne, acneSymp, "head", true));
        conditionsDB.add(new ConditionSymptoms(gerd, gerdSymp, "chest", false));
        conditionsDB.add(new ConditionSymptoms(hangover, hangoverSymp, "stomach", true));
        conditionsDB.add(new ConditionSymptoms(anemia, anemiaSymp, "stomach", true));
        conditionsDB.add(new ConditionSymptoms(cold, coldSymp, "head", true));
        conditionsDB.add(new ConditionSymptoms(pms, pmsSymp, "stomach", true));
        conditionsDB.add(new ConditionSymptoms(chalazion, chalazionSymp, "head", true));
        conditionsDB.add(new ConditionSymptoms(arthritis, arthritisSymp, "arms", true));
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
            if(c.getBodyPart().equalsIgnoreCase(bodyPart))
                symptoms.addAll(c.getSymptoms());
        }

        return symptoms;
    }

    /*
        We have coded it such that if the input symptoms match over 50% of the real symptoms in database
        then we consider it
     */
    @Override
    public ArrayList<Condition> getConditionsBySymptoms(ArrayList<Symptom> symptoms) {

//        int symptCounter;
//        ArrayList<Condition> conditions = new ArrayList<Condition>();
//
//        for (ConditionSymptoms c : conditionsDB) {
//            symptCounter = 0;
//
//            //prelim check of length to ignore the conditions
//            if(symptoms.size() >= c.getSymptoms().size()/2){
//                for(Symptom s : c.getSymptoms()){
//
//                }
//            }
//                commonConditions.add(c.getCondition());
//        }

        return null;
    }

}