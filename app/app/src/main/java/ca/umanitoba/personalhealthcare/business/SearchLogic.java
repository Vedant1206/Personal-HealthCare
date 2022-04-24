package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;

public interface SearchLogic {

    /**
     * Get a list of common conditions
     * @return  String array
     */
    String[] getCommonConditions();

    Condition getConditionResult(ArrayList<Symptom> selectedItems);

}
