package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;

public class BodyPartsLogic {

    String name;
    ArrayList<Symptom> symptoms;
    DiseasePersistence thisPersistence = Services.getDiseasePersistence();

    public BodyPartsLogic(String bodyPart) {

    name = bodyPart;
    symptoms = thisPersistence.getSymptomsByBodyPart(bodyPart);

    }

    public String getName() {return name;}
    public ArrayList<Symptom> getSymptoms() {return symptoms;}
}
