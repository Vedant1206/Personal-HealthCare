package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;

public class SearchLogicImp implements SearchLogic {

    private DiseasePersistence thisPersistence;     //DiseasePersistence
    private ArrayList<Condition> commonConditions;  //List of common conditions
    private String[] conditionStrings;              //String array to hold the
                                                    //names of the common conditions
    public SearchLogicImp() {
        thisPersistence = new FakeDiseasePersistence();
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

}
