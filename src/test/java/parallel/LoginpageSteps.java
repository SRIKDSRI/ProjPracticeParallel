package parallel;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import utilities.Reusablemethods;

public class LoginpageSteps extends Reusablemethods {
	
	public HomePage hp;
	public LoginPage lp;
	String actualTitle;
	public LandingPage landp;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		hp = new HomePage(getDriver());
	    lp = hp.navigateToLoginPage();
	}

	@When("User captures the title of the login page")
	public void user_captures_the_title_of_the_login_page() {
	    actualTitle = getDriver().getTitle();
	    System.out.println("ACTUAL TITLE NAME IS: "+ actualTitle);
	    
	}

	@Then("Title should be like {string}")
	public void title_should_be_like(String string) {
	    
	    Assert.assertEquals(string, actualTitle);
	    log.info("Title validation is done and is successfully");
	    
	}

	@When("User inputs {string} and {string}")
	public void user_inputs_and(String string, String string2) {
	    lp.getUsername().sendKeys(string);
	    lp.getPassword().sendKeys(string2);
	    log.info("credentials are accepted");
	    
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
	    landp = lp.clickLogin();
	    
	}

	@Then("User should be navigate to home page")
	public void user_should_be_navigate_to_home_page() {
	    getWDWait().until(ExpectedConditions.visibilityOf(landp.getName()));
	    Assert.assertEquals(true, landp.getName().isDisplayed());
	}

}
