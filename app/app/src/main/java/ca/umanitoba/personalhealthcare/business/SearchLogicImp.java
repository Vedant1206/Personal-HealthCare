package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.DiseasePersistenceHSQLDB;

public class SearchLogicImp implements SearchLogic {

    private ArrayList<Condition> conditionsArray;   //List of resulting conditions
    private ArrayList<Symptom> symptomsArray;       //List of selected symptoms
    private DiseasePersistence thisPersistence;     //DiseasePersistence
    private ArrayList<Condition> commonConditions;  //List of common conditions
    private String[] conditionStrings;              //String array to hold the
                                                    //names of the common conditions
    public SearchLogicImp() {
        thisPersistence = new FakeDiseasePersistence();
        commonConditions = thisPersistence.getCommonConditions();
        conditionStrings = createStrings(commonConditions);
    }

    public SearchLogicImp(DiseasePersistence injectedDB) {
        thisPersistence = injectedDB;
        commonConditions = thisPersistence.getCommonConditions();
        conditionStrings = createStrings(commonConditions);
    }

    /**
     * Takes an arrayList of Condition objects and extracts the
     * names of each condition and returns the list of names
     * as an array of Strings.
     *
     * @return String array
     */
    private String[] createStrings(ArrayList<Condition> conditions){
        String[] strings = new String[conditions.size()];

        for(int i=0; i<conditions.size(); i++){
            strings[i] = conditions.get(i).getName();
        }

        return strings;
    }

    /**
     * Get the list of common conditions
     * as a string array
     *
     * @return String[]
     */
    public String[] getCommonConditions(){ return conditionStrings; }

    /**
     * Get the Condition object to be shown on the results page,
     * based on the symptoms selected on the search page.
     * @return Condition
     */
    public String[] getConditionResult(ArrayList<String> selectedItems, String bodyPart){

        String[] conditions = null;

        symptomsArray = createSympList(selectedItems, bodyPart);
        conditionsArray = thisPersistence.getConditionBySymptoms(symptomsArray);
        if(conditionsArray != null){
            conditions = createStrings(conditionsArray);
        } else {
            conditions = null;
        }

        return conditions;

    }

    /**
     * Create an ArrayList of Symptom objects from an ArrayList of Strings and
     * a String specifying the bodyPart.
     */
    private ArrayList<Symptom> createSympList(ArrayList<String> selection, String bodyPart){
        symptomsArray = new ArrayList<>();
        for(int i = 0; i < selection.size(); i++){
            symptomsArray.add(new Symptom(selection.get(i), bodyPart));
        }
        return symptomsArray;
    }

}
