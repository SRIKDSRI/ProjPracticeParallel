package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	private By username = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//input[@name='commit']");
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public LandingPage clickLogin() {
	    driver.findElement(login).click();
	    return new LandingPage(driver);
	}
}
