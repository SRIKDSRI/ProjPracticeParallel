Feature: Verify the landing page elements

@smoke
Scenario: Verify the title of the landing page
Given User is on the landing page
When User captures the title of the landing page
Then Title should be like "Rahul Shetty Academy" in landing page

Scenario: User logsout from the landing page
Given User is on the landing page
When User clicks on profile button and clicks on logout button
Then User should be logged out and login button is displayed on the screen.