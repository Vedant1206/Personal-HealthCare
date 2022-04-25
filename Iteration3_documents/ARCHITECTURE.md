The architecture of our project includes a UI layer, a logic layer, a persistence layer, and some domain specific objects.

The UI layer consists of all the activity files in our project. The activity files are responsible for the GUI of our app.

The domain specific objects include the Guest, Patient, Member, Profile, User, Condition, Symptom, and ConditionSymptoms classes, as well as some classes for exceptions.

The persistence layer consists of a fake and a real database. The fake database has hardcoded data with domain specific objects. The real database is an HSQLDB database.

# File structure
```
personalhealthcare
├── application 
│   └── MainActivity.java                       -- Launch activity
├── business                                    -- Logic layer 
│   ├── AccountManager.java
│   ├── AccountManagerImp.java
│   ├── AddSymptomLogic.java
│   ├── AddSymptomLogicImp.java
│   ├── BodyPartsLogic.java
│   ├── BodyPartsLogicImp.java
│   ├── ProfileManager.java
│   ├── ProfileManagerImp.java
│   ├── ResultLogic.java
│   ├── ResultLogicImp.java
│   ├── SearchLogic.java
│   ├── SearchLogicLogicImp.java
│   ├── SessionManager.java
│   └── SessionManagerImp.java
├── objects                                     -- Domain-specific layer
│   ├── Condition.java
│   ├── ConditionSymptoms.java
│   ├── EmailExistException.java
│   ├── EmailInvalidException.java
│   ├── Guest.java
│   ├── LoginSession.java
│   ├── Member.java
│   ├── NameExistsException.java
│   ├── PasswordInvalidException.java
│   ├── Patient.java
│   ├── Profile.java
│   ├── Symptom.java
│   └── User.java
├── persistence                                 -- Database layer
│   ├── fakeDB
│   |   ├── FakeDiseasePersistence.java
│   |   ├── FakeMemberPersistence.java
│   |   ├── FakeProfilePersistence.java
│   ├── hsqldb
│   |   ├── DatabaseException.java
│   |   ├── DiseasePersistenceHSQLDB.java
│   |   ├── HsqldbConnection.java
│   |   ├── HsqldbMemberPersistence.java
│   |   ├── ProfilePersistenceHSQLDB.java
│   ├── DiseasePersistence.java
│   ├── LoginSessionPersistence.java
│   ├── LoginSessionPersistenceImp.java
│   ├── MemberPersistence.java
│   └── ProfilePersistence.java
├── presentation                                -- UI layer
│   ├── AddSymptomActivity.java
│   ├── BodyPartsActivity.java
│   ├── CreateAccountActivity.java
│   ├── EditProfileActivity.java
│   ├── LogInActivity.java
│   ├── ResultsActivity.java
│   ├── SearchActivity.java
│   ├── SelectProfileActivity.java
│   |   ├── ProfileItemViewList.java
│   |   ├── ProfilesAdapter.java
│   |   └── SelectProfileActivity.java
```
# Iteration 3 Diagram

[Diagram link](Iteration3_documents/ArchitectureDiagram.png)
