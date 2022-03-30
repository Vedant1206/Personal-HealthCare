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

    public String toString() {return name + ":\nAffected body parts: " + affectedBodyParts.toString()
            + "\nAssociated conditions: " + associatedConditions.toString() + "\n";}
    public boolean addAffectedBodyPart(String bodyPart){return affectedBodyParts.add(bodyPart);}
    public boolean addAssociatedCondition(String condition){return associatedConditions.add(condition);}
    public String getDescription() {return description;}
    public String getSymptomName() {return name;}
    public ArrayList<String> getAffectedBodyParts() {return affectedBodyParts;}
    public ArrayList<String> getAssociatedConditions() {return associatedConditions;}
}
