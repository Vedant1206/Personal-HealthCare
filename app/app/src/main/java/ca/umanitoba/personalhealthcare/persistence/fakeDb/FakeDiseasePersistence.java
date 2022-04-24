package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import java.util.ArrayList;

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
        Condition acne = new Condition("Acne", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/acne/symptoms-causes/syc-20368047", "Acne is a skin condition that occurs when your hair follicles become plugged with oil and dead skin cells. It causes whiteheads, blackheads or pimples. Acne is most common among teenagers, though it affects people of all ages.<br>Effective acne treatments are available, but acne can be persistent. The pimples and bumps heal slowly, and when one begins to go away, others seem to crop up.<br>Depending on its severity, acne can cause emotional distress and scar the skin. The earlier you start treatment, the lower your risk of such problems.<br>");
        Condition gerd = new Condition("Acid Reflux (GERD)", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/gerd/symptoms-causes/syc-20361940", "Gastroesophageal reflux disease (GERD) occurs when stomach acid frequently flows back into the tube connecting your mouth and stomach (esophagus). This backwash (acid reflux) can irritate the lining of your esophagus.<br>Many people experience acid reflux from time to time. GERD is mild acid reflux that occurs at least twice a week, or moderate to severe acid reflux that occurs at least once a week.<br>");
        Condition hangover = new Condition("Hangover", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/hangovers/symptoms-causes/syc-20373012", "A hangover is a group of unpleasant signs and symptoms that can develop after drinking too much alcohol. As if feeling awful weren't bad enough, frequent hangovers are also associated with poor performance and conflict at work.<br>As a general rule, the more alcohol you drink, the more likely you are to have a hangover the next day. But there's no magic formula to tell you how much you can safely drink and still avoid a hangover.<br>");
        Condition anemia = new Condition("Anemia", "MayoClinic", "https://www.mayoclinic.org/diseases-conditions/anemia/symptoms-causes/syc-20351360", "Anemia is a condition in which you lack enough healthy red blood cells to carry adequate oxygen to your body's tissues. Having anemia, also referred to as low hemoglobin, can make you feel tired and weak.<br>There are many forms of anemia, each with its own cause. Anemia can be temporary or long term and can range from mild to severe. In most cases, anemia has more than one cause. See your doctor if you suspect that you have anemia. It can be a warning sign of serious illness.<br>");
        Condition cold = new Condition("Cold", "WebMD", "https://www.webmd.com/cold-and-flu/features/cold-sinus-infections", "If it’s a cold virus, you may find yourself close to a tissue box for several days. Most of the time, colds get better on their own in 10 days or less.<br>" +
                "Because the common cold is a virus, antibiotics won’t help. But over-the-counter medications may make you feel better.<br>“The remedies you choose should be targeted at specific symptoms, so something for your headache, for your congestion, for your fever,” says Camelia Davtyan, MD, a professor of medicine at UCLA.<br>");
        Condition pms = new Condition("PMS", "WebMD", "https://www.webmd.com/women/pms/features/pms-signs-symptoms", "PMS affects almost all women to some degree during their reproductive years. <br>PMS is a catch-all name for a myriad of physical and psychological symptoms, it is thought to be caused by hormonal changes during the menstrual cycle. The exact cause, however, remains a mystery. Symptoms generally strike five-to-10 days before the period and dissipate with its start or soon after. Research has determined that women are not imagining anything -- and, thankfully, there is help.<br>");
        Condition chalazion = new Condition("Chalazion", "MedlinePlus", "https://medlineplus.gov/ency/article/001006.htm", "A chalazion is a small bump in the eyelid caused by a blockage of a tiny oil gland.<br>A chalazion often develops following an internal hordeolum (also called a stye). The eyelid most often becomes tender, red, swollen and warm. Sometimes, the blocked gland causing the stye will not drain even though the redness and swelling go away. The gland will form a firm nodule in the eyelid that is not tender. This is called a chalazion.<br>");
        Condition arthritis = new Condition("Arthritis", "MedlinePlus", "https://medlineplus.gov/ency/article/001243.htm", "Arthritis is inflammation or degeneration of one or more joints. A joint is the area where 2 bones meet. There are more than 100 different types of arthritis.<br>Arthritis involves the breakdown of structures of the joint, particularly cartilage. Normal cartilage protects a joint and allows it to move smoothly. Cartilage also absorbs shock when pressure is placed on the joint, such as when you walk. Without the normal amount of cartilage, the bones under the cartilage become damaged and rub together. This causes swelling (inflammation), and stiffness.<br>");

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

                    //ensuring repeated symptoms are not returned in the list
                    if(!symptoms.contains(symp))
                        symptoms.add(symp);
            }
        }


        return symptoms;
    }

    @Override
    public ArrayList<Condition> getConditionBySymptoms(ArrayList<Symptom> symptoms) {
        return null;
    }


    //  WILL THIS METHOD THROW SPECIFIC CONDITION_DNE EXCEPTION? ALSO SOUNDS LIKE THIS METHOD SHOULD NOT EXIST
    @Override
    public Condition getConditionByName(String condName) throws RuntimeException {
        Condition result = null;

        for(ConditionSymptoms c : conditionsDB){
            if(c.getCondition().getName().equalsIgnoreCase(condName)){
                result = c.getCondition();
                break;
            }
        }

        return result;
    }

}