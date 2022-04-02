# Iteration 2 Worksheet
## Paying off technical debt
Show two instances of your group paying off technical debt. For these two instances:

 - Explain how your are paying off the technical debt.
 - Show commits, links to lines in your commit where you paid off technical debt.
 - Classify the debt, and justify why you chose that classification with 1-3 sentences.

Example of how to link to a diff - click on he commit in the commit log, then click on the margin to the line: https://code.cs.umanitoba.ca/3350-winter-2021-a01/sample-project/-/commit/8e38ae9c3084d62adc4ac5fafa3b87d7d862dc26#72899361f89777662df76c5ce0ed847af04dff86_35_41


One example of where we paid off technical debt is in the Search Activity. In Iteration 1, we hardcoded a list of symptoms to be shown on the page, because we didn't have time to create a logic layer. In this iteration, we have used a logic class to send the information to be shown to the UI layer.

[Hardcoded data in UI layer](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/blob/90488f9bfae4b7129e95010e333f5de10a525ae7/app/app/src/main/java/ca/umanitoba/personalhealthcare/presentation/SearchActivity.java#L31)

[Data being passed to UI from Logic layer](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/blob/557089b8ca8ecfb744feb36e9a2c0dc9de6a3f97/app/app/src/main/java/ca/umanitoba/personalhealthcare/presentation/SearchActivity.java#L47)

The type of debt is reckless & deliberate because we knew how to create a Logic layer in iteration 1 but we chose not to because we were short on time. 

## SOLID
We could not find a SOLID violation in Group 16's project because their code is clean and their project is well-organized.

## Retrospective

The retrospective helped us change the way we plan our project. During Iteration 1 we mostly did the planning as we went along, but for Iteration 2 we were able to do a lot of the planning earlier on. Evidence of this includes the fact that we assigned user stories to each group member and added deadlines for those user stories.

[Link to an issue with a due date](https://code.cs.umanitoba.ca/winter-2022-a01/group-1/personal_healthcare/-/issues/14)

## Design patterns
Show links to your project where you use a well-known design pattern. Which pattern is it? Provide links to the design pattern that you used.

Note: Though Dependency Injection is a programming pattern, we would like to see a programming pattern other than Dependency Injections.

## Iteration 1 Feedback fixes
Provide a link to an issue opened by the grader.

Explain what the issue was, and why it was flagged. Explain what you did to refactor or fix your code to address the issue. Provide links to the commits where you fixed the issue.
