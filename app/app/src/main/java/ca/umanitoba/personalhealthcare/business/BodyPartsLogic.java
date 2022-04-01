package ca.umanitoba.personalhealthcare.business;

import android.util.Log;

import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;

public class BodyPartsLogic {

    private DiseasePersistence thisPersistence;
    private String name;
    private ArrayList<Symptom> symptoms;
    private String[] symptomStrings;

    public BodyPartsLogic(String bodyPart) {
        thisPersistence = new FakeDiseasePersistence();
        name = bodyPart;
        symptoms = thisPersistence.getSymptomsByBodyPart(bodyPart);
        symptomStrings = createSymptomStrings(symptoms);
    }

    private String[] createSymptomStrings(ArrayList<Symptom> symptoms){
        String[] strings = new String[symptoms.size()];
        for (int i = 0; i < symptoms.size(); i++) {
            strings[i] = symptoms.get(i).getSymptomName();
        }
        return strings;
    }

    public String getName() {return name;}
    public String[] getSymptoms() {return symptomStrings;}
}
