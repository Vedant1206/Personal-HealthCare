package ca.umanitoba.personalhealthcare.business;

public interface ResultsLogic {

    /**
     * Get the Condition name to be displayed in the results page
     * @return  String
     */
    String getConditionName();

    /**
     * Get the Condition source name to be displayed in the results page
     * @return  String
     */
    String getConditionSourceName();

    /**
     * Get the Condition source link to be displayed in the results page
     * @return  String
     */
    String getConditionSourceLink();

    /**
     * Get the Condition description to be displayed in the results page
     * @return  String
     */
    String getConditionDescription();

}