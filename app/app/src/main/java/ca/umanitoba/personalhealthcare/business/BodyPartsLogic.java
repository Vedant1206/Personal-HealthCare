package ca.umanitoba.personalhealthcare.business;

import android.util.Log;

import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.SymptomPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeSymptomPersistence;

public class BodyPartsLogic {

    String name;
    ArrayList<Symptom> symptoms;
    SymptomPersistence thisPersistence = new FakeSymptomPersistence();

    public BodyPartsLogic(String bodyPart) {

    name = bodyPart;
    symptoms = thisPersistence.getSymptomsByBodyPart(bodyPart);

    }

    public String[] getSymptomStrings(){
        String[] symptomStrings = new String[symptoms.size()];
        for (int i = 0; i < symptoms.size(); i++) {
            symptomStrings[i] = symptoms.get(i).getSymptomName();
        }
        return symptomStrings;
    }

    public String getName() {return name;}
    public ArrayList<Symptom> getSymptoms() {return symptoms;}
}
