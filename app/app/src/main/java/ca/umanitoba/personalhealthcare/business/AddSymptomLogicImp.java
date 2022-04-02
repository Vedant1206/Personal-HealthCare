package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

public class AddSymptomLogicImp implements AddSymptomLogic {

    private String symptomString;                   //String containing info about the reported symptom
    private String name;                            //Text input
    private String condition1;                      //Text input
    private String condition2;                      //Text input
    private String condition3;                      //Text input
    private Boolean head;                           //Checkbox input
    private Boolean chest;                          //Checkbox input
    private Boolean stomach;                        //Checkbox input
    private Boolean everywhere;                     //Checkbox input
    private ArrayList<String> affectedBodyParts;    //Body parts affected by this symptom
    private ArrayList<String> associatedConditions; //List of Condition objects associated with this symptom

    public AddSymptomLogicImp(String name, String condition1, String condition2, String condition3, Boolean head, Boolean chest, Boolean stomach, Boolean everywhere) {

        this.name=name;
        this.condition1=condition1;
        this.condition2=condition2;
        this.condition3=condition3;
        this.head=head;
        this.chest=chest;
        this.stomach=stomach;
        this.everywhere=everywhere;

        affectedBodyParts = createBodyPartsList(head, chest, stomach, everywhere);
        associatedConditions = createConditionsList(condition1, condition2, condition3);

        symptomString = createString(name, affectedBodyParts, associatedConditions);

    }

    /**
     * Takes the info input by the user and creates a big String
     * containing all that info.
     *
     * @return String
     */
    private String createString(String name, ArrayList<String> bodyParts, ArrayList<String> conditions){

        String result = name + ":\nAffected body parts: " + bodyParts.toString()
                + "\nAssociated conditions: " + conditions.toString() + "\n";

        return result;
    }

    /**
     * Takes info input by the user about which body parts are affected
     * by their reported symptom, and creates an ArrayList of Strings
     * containing the names of the body parts that are affected.
     */
    private ArrayList<String> createBodyPartsList(Boolean head, Boolean chest, Boolean stomach, Boolean everywhere){

        ArrayList<String> bodyParts = new ArrayList<>();
        if(everywhere) {
            bodyParts.add("head");
            bodyParts.add("chest");
            bodyParts.add("stomach");
            bodyParts.add("everywhere");
            return bodyParts;
        }
        if(head) {
            bodyParts.add("head");
        }
        if(chest) {
            bodyParts.add("chest");
        }
        if(stomach) {
            bodyParts.add("stomach");
        }
        return bodyParts;

    }

    /**
     * Takes info input by the user about which conditions are associated
     * with their reported symptom, and creates an ArrayList of Strings
     * containing the names of the conditions input by the user
     */
    private ArrayList<String> createConditionsList(String C1, String C2, String C3){

        ArrayList<String> conditions = new ArrayList<>();
        if(!C1.isEmpty()) {
            conditions.add(C1);
        }
        if(!C2.isEmpty()) {
            conditions.add(C2);
        }
        if(!C3.isEmpty()) {
            conditions.add(C3);
        }
        return conditions;

    }

    /**
     * Gets a big String containing all the info input by the user.
     *
     * @return String
     */
    public String getSymptomString(){return symptomString;}

}
