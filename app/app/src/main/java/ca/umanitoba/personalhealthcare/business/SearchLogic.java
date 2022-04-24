package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;

public interface SearchLogic {

    /**
     * Get a list of common conditions
     * @return  String array
     */
    String[] getCommonConditions();

    /**
     * Get the Condition object to be shown on the results page,
     * based on the symptoms selected on the search page.
     * @return Condition
     */
    String[] getConditionResult(ArrayList<String> selectedItems, String bodyPart);

}
