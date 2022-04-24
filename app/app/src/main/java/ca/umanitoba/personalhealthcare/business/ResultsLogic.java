package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Condition;

public interface ResultsLogic {

    /**
     * Get the Condition object to be displayed in the results page
     * @return  Condition
     */
    Condition getCondition();

}