# Iteration 2 Worksheet
## Paying off technical debt

One example of where we paid off technical debt is in the Search Activity. In Iteration 1, we hardcoded a list of symptoms to be shown on the page, because we didn't have time to create a logic layer. In this iteration, we have used a logic class to send the information to be shown to the UI layer.

[Hardcoded data in UI layer](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/blob/90488f9bfae4b7129e95010e333f5de10a525ae7/app/app/src/main/java/ca/umanitoba/personalhealthcare/presentation/SearchActivity.java#L31)

[Data being passed to UI from Logic layer](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/blob/557089b8ca8ecfb744feb36e9a2c0dc9de6a3f97/app/app/src/main/java/ca/umanitoba/personalhealthcare/presentation/SearchActivity.java#L47)

The type of debt is reckless & deliberate because we knew how to create a Logic layer in iteration 1 but we chose not to because we were short on time. 


Another example is 


## SOLID
We could not find a SOLID violation in Group 16's project because their code is clean and their project is well-organized.

## Retrospective

The retrospective helped us change the way we plan our project. During Iteration 1 we mostly did the planning as we went along, but for Iteration 2 we were able to do a lot of the planning earlier on. Evidence of this includes the fact that we assigned user stories to each group member and added deadlines for those user stories.

[Link to an issue with a due date](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/issues/14)

## Design patterns

We use the "Factory" design pattern in our [AddSymptomLogicImp](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/blob/main/app/app/src/main/java/ca/umanitoba/personalhealthcare/business/AddSymptomLogicImp.java) class because it basically acts like a factory for creating Strings from the users' input. The AddSymptomLogicImp class gets user input from the UI layer and creates a String representing all that data to be written in a txt file.


## Iteration 1 Feedback fixes

[This issue opened by Group 16](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/issues/22) was in our patient class. We had violated the Single Responsibility Principle by including some functions for the profile list in the patient object. It was fixed in [this merge request](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/merge_requests/25) by removing some functions from the patient class.
