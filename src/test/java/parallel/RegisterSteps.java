package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utilities.Reusablemethods;

public class RegisterSteps extends Reusablemethods {
	public HomePage hp;
	public String actualText;
	public RegisterPage rp;
	
	@Given("User is on the register page")
	public void user_is_on_the_register_page() throws InterruptedException {
	    
		hp = new HomePage(getDriver());
		rp = hp.navigateToRegisterPage();
		Thread.sleep(2000);
	}

	@When("User captures the signup button text")
	public void user_captures_the_signup_button_text() {
	    
	    actualText = rp.getBtnText();
	}

	@Then("text displayed should be like {string}")
	public void text_displayed_should_be_like(String string) {
	    
	    Assert.assertEquals(actualText,string);
	}
	

}
