Feature: Adactin Hotel Application smoke test cases
This feature file includes launching the url user login

Scenario: verify valid login functionality of adactin hotel application
Given Launch the adactin hotel web application
Then verify the logo of the page is displayed
When User should enter the Email Id
And User should enter the password
And User should click on the login button


