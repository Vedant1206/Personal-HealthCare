Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Our feature was [Create user accounts/profile(s)](winter-2022-a01/group-1/personal_healthcare#1) which had 2 User stories linked within it. Each user story had its own linked set of Developer Tasks.

Our group initially got together to loosely plan out all parts of the Iteration planning. We used the first few meetings to:
- plan the UI navigation flow (which Activities would show up at app launch, and clicking which buttons can take us to related Activities etc)
- decide upon Branching Strategy
- plan the archituecture template and list the structure and requirements of the Data/Logic Classes and Android activities
- assign each member a User story and documentation tasks
Whiteboard pictures of our initial plan are linked [here](Iteration1_documents/Rough_whiteboard_plans) 

Two of our Group members were assigned to the Account creation feature. They decided amongst themselves to individually take up the UI layer (ie making all the Android activities) and the Data layer (making hirearchy of classes that stores Guest/Registered Users and Profiles). They continuously communicated with each other and informed the group when changes were made. And during the group meetings, they worked with the rest of us in combining their Android activities with ours to complete the UI navigation flow of the app. 

[Link to our final Merge request](winter-2022-a01/group-1/personal_healthcare!35)
[Link to our Final merge commit](58a597d57c4bbc2ecc9c05309cb29644c8c33f5c)

Exceptional code
----------------

We do not have many tests as our in current iteration, we mainly worked on building UI activities and creating the skeleton classes structure for future Iterations. The java DSO classes have mainly getters and setters so they also don't have tests to go along.  

Branching
----------

[Link to our Branching Strategy](Iteration1_documents/branching_strategy.md)

[Link to Branching Strategy screenshot](Iteration1_documents/BranchingStrategyPic.PNG)

SOLID
-----

[Link to the SOLID violation](winter-2022-a01/group-2/student-study-stats#45)

Agile Planning
--------------

We had to push a few User stories to the next iteration. Namely,
- [As a user who wants to have access to extra features, I want to create an account with a default/primary profile.](winter-2022-a01/group-1/personal_healthcare#14)
- [As a user, I want to report/add new symptoms if I could not find my symptoms in the list.](winter-2022-a01/group-1/personal_healthcare#16)
- [As a user who wants to use the app with my family members, I want to add extra profiles for my family.](winter-2022-a01/group-1/personal_healthcare#17)
- [As a user, I want to search for the details of the disease to get more information.](winter-2022-a01/group-1/personal_healthcare#15)
- [As a user, I get all the probable causes based on the provided symptoms.](winter-2022-a01/group-1/personal_healthcare#13)

We also brought a User story up from Iteration 2 and implemented now because along the way, the assigned group member thought that it would be better implemented.
-  [Search from the list of common conditions (I.e., cough, cold, headache)](winter-2022-a01/group-1/personal_healthcare#11)

Documenting our code well and setting standard Git workflow for the group took longer than expected. Which resulted in having lesser time to code. 
We also overestimated the scale of our Features. Initially, we expected that we would have features implemented with scaleable logic/database, and a nice looking UI. But realistically, coding in Android studio took longer and we had to stop at making the UI only functional to give the attention to other aspects 

Our convention to name the issues now includes the type of the artifact in [square brackets] the titles as along with the tags. This way, the titles becomes strikingly apparent, which helps in distinguishing things when we are dealing with a lot of open issues at once.
