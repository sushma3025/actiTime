Feature: Test the Application

Background: User is Logged In
Given I navigate to the login page
When I enter Username and Password
|userName|admin|
|password|manager|
Then I should be logged in


Scenario: User should be able to create and verify tasks
Given I click on tasks
And I click on Add new Customer
When I enter the details
|customerName|Cucumbers|
Then I should see the task created
|customerName|Cucumbers|

