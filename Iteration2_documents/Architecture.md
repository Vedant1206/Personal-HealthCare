The architecture of our project includes a UI layer, a logic layer, a persistence layer, and some domain specific objects.

The UI layer consists of all the activity files in our project. The activity files are responsible for the GUI of our app.

The domain specific objects include the Guest, Patient, Member, Profile, User, Condition, Symptom, and ConditionSymptoms classes, as well as some classes for exceptions.

The persistence layer consists of hard-coded data inside the activity classes for now.

# File structure
```
personalhealthcare
├── MainActivity.java                           -- Launch activity
├── business                                    -- Logic layer 
├── objects                                     -- Domain-specific layer
│   ├── Control.java
│   ├── Guest.java
│   ├── Member.java
│   ├── Patient.java
│   ├── Profile.java
│   └── User.java
├── persistence                                 -- Database layer
├── presentation                                -- UI layer
    ├── BodyPartsActivity.java
    ├── ColdActivity.java
    ├── CreateAccountActivity.java
    ├── HeadacheActivity.java
    ├── HeadActivity.java
    ├── LogInActivity.java
    ├── NauseaActivity.java
    ├── SearchActivity.java
    └── StomachActivity.java
```
# Iteration 2 Diagram

[Diagram link](Iteration2_documents/ArchitectureDiagram.png)
