Feature: Verify the user actions on login page

Scenario: Verify the title of the login page
Given User is on the login page
When User captures the title of the login page
Then Title should be like "Rahul Shetty Academy"

Scenario Outline: Verify that user can login using only valid credentials
Given User is on the login page
When User inputs "<username>" and "<password>"
And User clicks on submit button
Then User should be navigate to home page

Examples:
|username|password|
|srikanth.dasari.88@gmail.com|9mother12|
|srikanth.dasari.88@gmail.com|9mother12|