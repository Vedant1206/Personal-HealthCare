package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;

public class BodyPartsLogicImp implements BodyPartsLogic{

    private DiseasePersistence thisPersistence; //DiseasePersistence
    private String name;                        //Name of the selected body part
    private ArrayList<Symptom> symptoms;        //List of symptoms associated with this body part
    private String[] symptomStrings;            //List of symptoms associated with this body part
                                                //stored as strings.
    public BodyPartsLogicImp(String bodyPart) {
        thisPersistence = new FakeDiseasePersistence();
        name = bodyPart;
        symptoms = thisPersistence.getSymptomsByBodyPart(bodyPart);
        symptomStrings = createSymptomStrings(symptoms);
    }

    public BodyPartsLogicImp(String bodyPart, DiseasePersistence injectedDB) {
        thisPersistence = injectedDB;
        name = bodyPart;
        symptoms = thisPersistence.getSymptomsByBodyPart(bodyPart);
        symptomStrings = createSymptomStrings(symptoms);
    }

    /**
     * Takes the list of Symptom objects and returns
     * the names of all those symptoms stored in
     * a String array.
     *
     * @return String[]
     */
    private String[] createSymptomStrings(ArrayList<Symptom> symptoms){
        String[] strings = new String[symptoms.size()];
        for (int i = 0; i < symptoms.size(); i++) {
            strings[i] = symptoms.get(i).getSymptomName();
        }
        return strings;
    }

    /**
     *Returns the name of the selected body part
     * @return String
     */
    public String getName() {return name;}

    /**
     *Returns a list of symptoms associated with this body part
     * @return String
     */
    public String[] getSymptoms() {return symptomStrings;}
}
