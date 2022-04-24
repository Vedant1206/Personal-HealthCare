package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.DiseasePersistenceHSQLDB;

public class SearchLogicImp implements SearchLogic {

    private DiseasePersistence thisPersistence;     //DiseasePersistence

    public SearchLogicImp() {
        thisPersistence = new FakeDiseasePersistence();
    }

    public SearchLogicImp(DiseasePersistence injectedDB) {
        thisPersistence = injectedDB;
    }

    /**
     * Takes an arrayList of Condition objects and extracts the
     * names of each condition and returns the list of names
     * as an array of Strings.
     *
     * @param conditions An ArrayList of conditions
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
     * Create an ArrayList of Symptom objects from an ArrayList of Strings and
     * a String specifying the bodyPart.
     *
     * @param selection Symptoms selected by the user
     * @param bodyPart Body Part selected by the user
     * @return ArrayList
     */
    private ArrayList<Symptom> createSympList(ArrayList<String> selection, String bodyPart){
        ArrayList<Symptom> symptomsArray = new ArrayList<>();
        for(int i = 0; i < selection.size(); i++){
            symptomsArray.add(new Symptom(selection.get(i), bodyPart));
        }
        return symptomsArray;
    }

    /**
     * Get a list of names of common conditions
     *
     * @return  String array
     */
    public String[] getCommonConditions(){
        ArrayList<Condition> commonConditions = thisPersistence.getCommonConditions();
        String[] conditionStrings = createStrings(commonConditions);
        return conditionStrings;
    }

    /**
     * Get the names of the conditions that will be displayed, based
     * on the symptoms that the user selects.
     *
     * @param selectedItems Symptoms selected by the user
     * @param bodyPart Body part selected by the user
     * @return String[]
     */
    public String[] getConditionResult(ArrayList<String> selectedItems, String bodyPart){

        String[] conditions = null;
        ArrayList<Symptom> symptomsArray = createSympList(selectedItems, bodyPart);
        ArrayList<Condition> conditionsArray = thisPersistence.getConditionBySymptoms(symptomsArray);

        if(conditionsArray != null){
            conditions = createStrings(conditionsArray);
        }

        return conditions;
    }

}
