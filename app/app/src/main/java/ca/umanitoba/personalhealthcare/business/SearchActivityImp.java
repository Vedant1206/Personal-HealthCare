package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.persistence.SymptomPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeSymptomPersistence;

public class SearchActivityImp implements SearchActivityLogic{

    SymptomPersistence thisPersistence = new FakeSymptomPersistence();



}
