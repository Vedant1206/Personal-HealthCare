package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.SymptomPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeSymptomPersistence;

public class SearchActivityLogicImp implements SearchActivityLogic{

    DiseasePersistence thisPersistence;
    ArrayList<Condition> commonConditions;

    public SearchActivityLogicImp() {
        thisPersistence = new FakeDiseasePersistence();
        commonConditions = thisPersistence.getCommonConditions();
    }

    public String[] getCommonSymptoms(){
        return null;
    }

}
