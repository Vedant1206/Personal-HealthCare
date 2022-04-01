package ca.umanitoba.personalhealthcare.business;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.SymptomPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeSymptomPersistence;

/**
 * This class uses the persistence class and returns
 * the description to Search Activity
 * */
public class DataActivityClass {

    //instance variable
    SymptomPersistence instance;

    //constructor
    public DataActivityClass(){
        instance = new FakeSymptomPersistence();
    }

    //returning name of the symptom
    public String getName(String name){
        Symptom temp = instance.getSymptomByName(name);
        String des = temp.getSymptomName();
        return des;
    }

}