package ca.umanitoba.personalhealthcare.persistence;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;

public interface DiseasePersistence {

    /**
     Gives a list of common conditions
     */
    // maybe allow input on how many common conditions do they want
    public ArrayList<Condition> getCommonConditions();

    /**
        This method fetches a list of Symptoms from Database based on bodyPart input
     */
    // check if bodypart needs to be an Object
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart);


    //maybe throw an exception if no symptoms are added
    public ArrayList<Condition> getConditionsBySymptoms(ArrayList<Symptom> symptoms);
}
