package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.DiseasePersistenceHSQLDB;

public class ResultsLogicImp implements ResultsLogic {

    private DiseasePersistence thisPersistence;     //DiseasePersistence
    private Condition thisCondition;                //Condition

    public ResultsLogicImp(String conditionToShow) {
        thisPersistence = new FakeDiseasePersistence();
        thisCondition = thisPersistence.getConditionByName(conditionToShow);
    }

    /**
     * Get the Condition information
     * as a string
     *
     * @return String
     */
    public Condition getCondition(){ return thisCondition;}

}