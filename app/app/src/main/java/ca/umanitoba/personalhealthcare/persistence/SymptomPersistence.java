package ca.umanitoba.personalhealthcare.persistence;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Symptom;

public interface SymptomPersistence {
    Symptom getSymptomByName(String name);
    ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart);
}
