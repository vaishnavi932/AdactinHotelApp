Feature: Adactin Hotel Application smoke test cases
This feature file includes launching the url user login

Scenario: verify valid login functionality of adactin hotel application
Given Launch the adactin hotel web application
#Then verify the logo of the page is displayed
When User should enter the Email Id
When User should enter the password
And User should click on the login button

Scenario: To verify whether the check-out date field accepts a later date than checkin date
Given Launch the adactin hotel web application
When Login to the application using username and password 
When Select location as in test data
When Select hotel as in test data 
When Select room type as in test data 
When Select no-of-rooms as in test data 
When Select number of children in test data
When Enter check-in-date later than the checkout-date field as in test data
Then Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’

Scenario: To check correct Final billed price is Total Price + 10% Total price in Book a Hotel page
Given Launch the adactin hotel web application
When Login to the application using username and password
When Select location as in test data
When Select hotel as in test data
When Select room type as in test data 
When Select no-of-rooms as in test data 
When Select number of children in test data
When Enter check-in-date later than the checkout-date field as in test data
When Click on Search button
When Select the hotel and click on continue button
Then Verify that total-price is being calculated as (price-pernight*no-ofrooms*no-of-days)




















