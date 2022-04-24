package ca.umanitoba.personalhealthcare.business;

public interface ResultsLogic {

    /**
     * Get the Condition name to be displayed in the results page
     * @return  String
     */
    String getConditionName();

    String getConditionSourceName();

    String getConditionSourceLink();

    String getConditionDescription();

}