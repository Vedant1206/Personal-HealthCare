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
        return null;
    }

    @Override
    //returns the symptom according to body part
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart) {
        return symptomList;
    }

    @Override
    public ArrayList<Condition> getConditionsBySymptoms(ArrayList<Symptom> symptoms) {
        return null;
    }


    // IGNORE THE CODE BELOW FOR NOW. IT IS NON-FUNCTIONAL IN THIS CLASS



    //returns the symptom according to name
    public Symptom getSymptomByName(String name) {
        if (name.equals("Headache")) {
            return symptomList.get(0);
        } else if (name.equals("Nausea")) {
            return symptomList.get(1);
        } else if (name.equals("Fever, flue, Cold")) {
            return symptomList.get(2);
        }
        return new Symptom("", "");
    }



    /**
     * All the data that will be shown in the list
     */
    private String cold() {
        return "Cough syrups\\n\" +\n" +
                "                \"Over-the-counter cough and cold medicines are intended to treat the symptoms\" +\n" +
                "                \" of coughs and colds, not the underlying disease. Research suggests that \" +\n" +
                "                \"these medicines haven't been proved to work any better to treat colds than \" +\n" +
                "                \"do inactive medicine (placebo).\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"If you use over-the counter cough and cold medicines, follow the label \" +\n" +
                "                \"directions. Don't take two medicines with the same active ingredient,\" +\n" +
                "                \" such as an antihistamine, decongestant or pain reliever. Too much of a \" +\n" +
                "                \"single ingredient could lead to an accidental overdose.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Don't use over-the-counter medicines, except for fever reducers and pain \" +\n" +
                "                \"relievers, to treat coughs and colds in children younger than 6 years old.\" +\n" +
                "                \" Cough and cold medications have potentially serious side effects, including \" +\n" +
                "                \"fatal overdoses in children younger than 2 years old. Also consider avoiding\" +\n" +
                "                \" use of these medicines for children younger than 12 years old. And it isn't\" +\n" +
                "                \" typically recommended that you give cough or cold medicines to an older child.";
    }

    private String nausea() {
        return "Take it easy. Too much activity and not getting enough rest might make \" +\n" +
                "                \"nausea worse.\\n\" +\n" +
                "                \"Stay hydrated. Take small sips of cold, clear, carbonated or sour drinks,\" +\n" +
                "                \" such as ginger ale, lemonade and water. Mint tea also may help. Oral rehydration\" +\n" +
                "                \" solutions, such as Pedialyte, can aid in preventing dehydration.\\n\" +\n" +
                "                \"Avoid strong odors and other triggers. Food and cooking smells, perfume, \" +\n" +
                "                \"smoke, stuffy rooms, heat, humidity, flickering lights, and driving are among\" +\n" +
                "                \" the possible triggers of nausea and vomiting.\\n\" +\n" +
                "                \"Eat bland foods. Start with easily digested foods such as gelatin, crackers and\" +\n" +
                "                \" toast. When you can keep these down, try cereal, rice, fruit, and salty or\" +\n" +
                "                \" high-protein, high-carbohydrate foods. Avoid fatty or spicy foods. Wait to \" +\n" +
                "                \"eat solid foods until about six hours after the last time you vomited.\\n\" +\n" +
                "                \"Use over-the-counter (OTC) motion sickness medicines. If you're planning a trip,\" +\n" +
                "                \" OTC motion sickness drugs, such as dimenhydrinate (Dramamine) or meclizine \" +\n" +
                "                \"(Rugby Travel Sickness) may help calm your queasy stomach. For longer journeys, \" +\n" +
                "                \"such as a cruise, ask your doctor about prescription motion sickness adhesive \" +\n" +
                "                \"patches, such as scopolamine (Transderm Scop).";
    }

    private String headacheData() {
        return "Tension-type headaches\n" +
                "Tension-type headaches, the most common variety of headaches:\n" +
                "\n" +
                "Might be felt as a tight band of pain around your head, a dull ache or pressure\n" +
                "Might cause mild to moderate pain on both sides of the head\n" +
                "Vary widely in frequency\n" +
                "Can be occasional\n" +
                "May occur more than 15 days a month (chronic)\n" +
                "Last from 30 minutes to a week\n" +
                "Treatment\n" +
                "Most occasional tension-type headaches are easily treated with over-the-counter medications, including:\n" +
                "\n" +
                "Aspirin\n" +
                "Ibuprofen (Advil, Motrin IB, others)\n" +
                "Acetaminophen (Tylenol, others)\n" +
                "Daily prescription medications, including tricyclic antidepressants, might manage chronic tension-type headaches. Alternative therapies aimed at stress reduction might help. They include:\n" +
                "\n" +
                "Cognitive behavioral therapy\n" +
                "Biofeedback\n" +
                "Massage therapy\n" +
                "Acupuncture\n" +
                "Migraines\n" +
                "Migraines are another common type of headache. They affect three times more women than men. Migraines typically:\n" +
                "\n" +
                "Cause pain that is moderate to severe\n" +
                "Pulsate\n" +
                "Cause nausea, vomiting, or increased sensitivity to light or sound\n" +
                "Affect only one side of your head, but can affect both sides\n" +
                "Worsen with activity such as climbing steps\n" +
                "Last from four to 72 hours without treatment\n" +
                "Treatment\n" +
                "Migraine treatment is aimed at relieving symptoms and preventing additional attacks. If you know what triggers your migraines, avoiding those triggers and learning how to manage them can help prevent migraines or lessen the pain. Treatment might include:\n" +
                "\n" +
                "Rest in a quiet, dark room\n" +
                "Hot or cold compresses to your head or neck\n" +
                "Massage and small amounts of caffeine\n" +
                "Over-the-counter medications such as ibuprofen (Advil, Motrin IB, others), acetaminophen (Tylenol, others) and aspirin\n" +
                "Prescription medications including triptans, such as sumatriptan (Imitrex) and zolmitriptan (Zomig)\n" +
                "Preventive medications such as metoprolol (Lopressor), propranolol (Innopran, Inderal, others), amitriptyline, divalproex (Depakote), topiramate (Qudexy XR, Trokendi XR ,Topamax) or erenumab-aooe (Aimovig)" +
                "Source -> https://www.mayoclinic.org/diseases-conditions/chronic-daily-headaches/in-depth/headaches/art-20047375";


    }

}