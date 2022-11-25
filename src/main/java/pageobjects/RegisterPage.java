package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By btnText = By.xpath("//button[normalize-space()='Sign up with email']");
	
	public String getBtnText() {
		return driver.findElement(btnText).getText();
	}
	

}
