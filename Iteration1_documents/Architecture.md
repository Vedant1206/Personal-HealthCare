The architecture of our project includes a UI layer, a logic layer, a persistence layer, and some domain specific objects.

The UI layer consists of all the activity files in our project. The activity files are responsible for the GUI of our app.

The domain specific objects include the Guest, Patient, Member, Profile, and User classes.

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
# Iteration 1 Diagram

[Diagram link](Iteration1_documents/ArchitectureDiagram.png)