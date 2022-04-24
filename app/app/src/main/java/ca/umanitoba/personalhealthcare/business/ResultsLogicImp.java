package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.DiseasePersistenceHSQLDB;

public class ResultsLogicImp implements ResultsLogic {

    private DiseasePersistence thisPersistence;     //DiseasePersistence
    private Condition thisCondition;                //Condition

    public ResultsLogicImp(){
        thisPersistence = new FakeDiseasePersistence();
        thisCondition = null;
    }

    public ResultsLogicImp(String conditionToShow) {
        thisPersistence = new FakeDiseasePersistence();
        thisCondition = thisPersistence.getConditionByName(conditionToShow);
    }

    public ResultsLogicImp(DiseasePersistence injectedDB){
        thisPersistence = injectedDB;
        thisCondition = null;
    }

    public ResultsLogicImp(DiseasePersistence injectedDB, String conditionToShow) {
        thisPersistence = injectedDB;
        thisCondition = thisPersistence.getConditionByName(conditionToShow);
    }

    /**
     * Get the Condition object
     *
     * @return Condition
     */
    public Condition getCondition(){
        Condition c = null;
        if(thisCondition != null) {
            c = thisCondition;
        } else {
            c = new Condition("Unkown", "", "", "This is an unknown condition");
        }
        return c;
    }

}