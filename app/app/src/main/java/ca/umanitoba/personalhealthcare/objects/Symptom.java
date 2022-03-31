package ca.umanitoba.personalhealthcare.objects;

import java.util.ArrayList;

public class Symptom {
    String name;
    String description;
    ArrayList<String> affectedBodyParts;
    ArrayList<String> associatedConditions;

    public Symptom(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Symptom(String name, ArrayList<String> affectedBodyParts, ArrayList<String> associatedConditions){
        this.name = name;
        this.affectedBodyParts = affectedBodyParts;
        this.associatedConditions = associatedConditions;
    }
}

