package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Symptom;

public class AddSymptomLogic {

    Symptom thisSymptom;
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

    public AddSymptomLogic(String name, String condition1, String condition2, String condition3, Boolean head, Boolean chest, Boolean stomach, Boolean everywhere) {

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

        thisSymptom = new Symptom(name, affectedBodyParts, associatedConditions);

    }

    public ArrayList<String> createBodyPartsList(Boolean head, Boolean chest, Boolean stomach, Boolean everywhere){

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

    public ArrayList<String> createConditionsList(String C1, String C2, String C3){

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

}
