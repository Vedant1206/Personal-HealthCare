package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeDiseasePersistence;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.DiseasePersistenceHSQLDB;

public class ResultsLogicImp implements ResultsLogic {

    private DiseasePersistence thisPersistence;     //DiseasePersistence
    private Condition thisCondition;                //Condition object
    private String conditionName;                   //Name of the condition
    private String conditionSourceName;             //Condition source name
    private String conditionSourceLink;             //Condition source link
    private String conditionDescription;            //Description of the condition

    public ResultsLogicImp(){
        thisPersistence = new FakeDiseasePersistence();
        thisCondition = null;
        setConditionInfo();
    }

    public ResultsLogicImp(String conditionToShow) {
        thisPersistence = new FakeDiseasePersistence();
        try {
            thisCondition = thisPersistence.getConditionByName(conditionToShow);
        } catch(RuntimeException e) {
            thisCondition = null;
        }
        setConditionInfo();
    }

    public ResultsLogicImp(DiseasePersistence injectedDB){
        thisPersistence = injectedDB;
        thisCondition = null;
        setConditionInfo();
    }

    public ResultsLogicImp(DiseasePersistence injectedDB, String conditionToShow) {
        thisPersistence = injectedDB;
        try {
            thisCondition = thisPersistence.getConditionByName(conditionToShow);
        } catch(RuntimeException e) {
            thisCondition = null;
        }
        setConditionInfo();
    }

    private void setConditionInfo(){
        if(thisCondition != null) {
            conditionName = thisCondition.getName();
            conditionDescription = thisCondition.getDescription();
            conditionSourceLink = thisCondition.getSourceLink();
            conditionSourceName = thisCondition.getSourceName();
        } else {
            conditionName = "Unknown";
            conditionDescription = "This is an unknown condition";
            conditionSourceLink = "";
            conditionSourceName = "";
        }
    }

    public String getConditionName(){
        return conditionName;
    }

    public String getConditionSourceName(){
        return conditionSourceName;
    }

    public String getConditionSourceLink(){
        return conditionSourceLink;
    }

    public String getConditionDescription(){
        return conditionDescription;
    }

}