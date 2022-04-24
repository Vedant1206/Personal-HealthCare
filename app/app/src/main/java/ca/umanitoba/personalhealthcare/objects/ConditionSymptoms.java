package ca.umanitoba.personalhealthcare.objects;

import java.util.ArrayList;

/**
 This class brings together the individual Condition object with its Symptom objects
 as well as their combined metadata.

 This DSO is mainly used for fake implementation of DiseasePersistence

 There is no good hirearchy to put on Conditions or Symptoms, and currently the other classes
 use one or the other object individually, so its a waste to have a containment of Symptoms
 within the Condition because there might be many symptom repeats. So for now, we are just
 linking them both under a superclass.

 This is Aggregation of Condition and relating Symptom objects!

 */
public class ConditionSymptoms {
    private Condition condition;
    private ArrayList<Symptom> symptomList;
    private boolean isCommonDisease;

    public ConditionSymptoms(Condition condition, ArrayList<Symptom> symptoms, boolean isCommon){
        this.condition = condition;
        this.symptomList = symptoms;
        this.isCommonDisease = isCommon;
    }

    public Condition getCondition() {return condition;}
    public ArrayList<Symptom> getSymptoms() {return symptomList;}
    public boolean isCommonDisease() {return isCommonDisease;}
}
