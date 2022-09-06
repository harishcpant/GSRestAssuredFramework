Feature: UI Test

# -------UI Login Test---------------------
#@UITest
#Scenario: Validate the login functionality positive test
#Given I Open the login page
#When I enter the valid username and password
#Then I should land successfully to secure area page

@UITest
Scenario: Validate the login functionality Negative test
Given I Open the login page
When I enter the invalid username and password
Then I should get the an error



