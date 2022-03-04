# File structure
personalhealthcare
├── MainActivity.java                           -- Launch activity
├── business                                    -- Logic layer 
├── objects                                     -- Domain-specific layer
│   ├── Control.java
│   ├── Guest.java
│   ├── Member.java
│   ├── Patient.java
│   ├── Profile.java
│   └── User.java
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


Note: Implementation of Persistence layer is left for the next iteration, and to replicate its functionality, some Strings have been hardcoded in several UI classes which reflect symptoms.