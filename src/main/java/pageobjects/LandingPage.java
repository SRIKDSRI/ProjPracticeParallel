package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By name = By.xpath("//span[@class='navbar-current-user']");
	private By logout = By.xpath("//a[normalize-space()='Log Out']");
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	
	//below methods are for more step definitions
	public String getTitle() {
		return driver.getTitle();
	}
	
	public WebElement logout() {
		return driver.findElement(logout);
	}
	
	
	
}
