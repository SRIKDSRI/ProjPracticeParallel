package parallel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import utilities.Reusablemethods;

public class LandingPageSteps extends Reusablemethods {
	
	public HomePage hp;
	public LoginPage lp;
	String actualTitle;
	public LandingPage landp;
	
	@Given("User is on the landing page")
	public void user_is_on_the_landing_page() throws InterruptedException {
		hp = new HomePage(getDriver());
	    lp = hp.navigateToLoginPage();
	    lp.getUsername().sendKeys(prop.getProperty("username"));
	    lp.getPassword().sendKeys(prop.getProperty("password"));
	    landp = lp.clickLogin();
	    Thread.sleep(2000);
	}

	@When("User captures the title of the landing page")
	public void user_captures_the_title_of_the_landing_page() throws InterruptedException {
	 actualTitle = landp.getTitle();
	 Thread.sleep(2000);
	}
	

@Then("Title should be like {string} in landing page")
public void title_should_be_like_in_landing_page(String string) {
	  Assert.assertEquals(string, actualTitle);
}

	@When("User clicks on profile button and clicks on logout button")
	public void user_clicks_on_profile_button_and_clicks_on_logout_button() throws InterruptedException {
	 landp.getName().click();
	 getWDWait().until(ExpectedConditions.elementToBeClickable(landp.logout()));
	  landp.logout().click();
	
	}

	@Then("User should be logged out and login button is displayed on the screen.")
	public void user_should_be_logged_out_and_login_button_is_displayed_on_the_screen() {
		getWDWait().until(ExpectedConditions.visibilityOfElementLocated(hp.login));
		
	  Assert.assertTrue(getDriver().findElement(hp.login).isDisplayed());
	}

}
