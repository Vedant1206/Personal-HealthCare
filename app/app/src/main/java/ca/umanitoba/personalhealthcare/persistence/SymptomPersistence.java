package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.Symptom;

public interface SymptomPersistence {
    Symptom getSymptomByName(String name);
}
