package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;

public class SearchActivityLogicImp implements SearchActivityLogic{

    DiseasePersistence thisPersistence;
    ArrayList<Condition> commonConditions;
    String[] conditionStrings;

    public SearchActivityLogicImp() {
        thisPersistence = new FakeDiseasePersistence();
        commonConditions = thisPersistence.getCommonConditions();
        conditionStrings = createStrings(commonConditions);
    }

    private String[] createStrings(ArrayList<Condition> conditions){
        String[] strings = new String[conditions.size()];

        for(int i=0; i<conditions.size(); i++){
            strings[i] = conditions.get(i).getName();
        }

        return strings;
    }

    public String[] getCommonConditions(){ return conditionStrings; }

}
