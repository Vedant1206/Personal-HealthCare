package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

public class AddSymptomLogicImp implements AddSymptomLogic {

    String symptomString;
    String name;
    String condition1;
    String condition2;
    String condition3;
    Boolean head;
    Boolean chest;
    Boolean stomach;
    Boolean everywhere;
    ArrayList<String> affectedBodyParts;
    ArrayList<String> associatedConditions;

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

    private String createString(String name, ArrayList<String> bodyParts, ArrayList<String> conditions){

        String result = name + ":\nAffected body parts: " + bodyParts.toString()
                + "\nAssociated conditions: " + conditions.toString() + "\n";

        return result;
    }

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

    public String getSymptomString(){return symptomString;}

}
