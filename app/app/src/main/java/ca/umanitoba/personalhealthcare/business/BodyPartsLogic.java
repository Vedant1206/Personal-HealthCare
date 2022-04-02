package ca.umanitoba.personalhealthcare.business;

public interface BodyPartsLogic {

    /**
     * Get the name of the selected BodyPart
     * @return  String
     */
    String getName();

    /**
     * Get a list symptoms that are associated
     * with this body part
     *
     * @return  String array
     */
    String[] getSymptoms();

}
