package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Condition;

public interface ResultsLogic {

    /**
     * Get the list of conditions to be displayed
     * @return  String array
     */
    public Condition getCondition();


}