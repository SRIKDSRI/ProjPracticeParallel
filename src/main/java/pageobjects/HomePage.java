package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By login = By.xpath("//a[@class='theme-btn']");
	
	public By register = By.xpath("//a[@class='theme-btn register-btn']");
	
	public LoginPage navigateToLoginPage() {
		
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		
		driver.findElement(register).click();
		return new RegisterPage(driver);
	}


	
}
