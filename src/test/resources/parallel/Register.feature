Feature: Verify the text in register page

@smoke
Scenario: Verify the button text in register page
    Given User is on the register page
    When User captures the signup button text
    Then text displayed should be like "Sign up with email"
    	