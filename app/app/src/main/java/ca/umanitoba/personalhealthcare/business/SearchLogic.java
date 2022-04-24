package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;

public interface SearchLogic {

    /**
     * Get a list of names of common conditions
     * @return  String array
     */
    String[] getCommonConditions();

    /**
     * Get the names of the conditions that will be displayed, based
     * on the symptoms that the user selects.
     *
     * @param selectedItems Symptoms selected by the user
     * @param bodyPart Body part selected by the user
     * @return String[]
     */
    String[] getConditionResult(ArrayList<String> selectedItems, String bodyPart);

}
