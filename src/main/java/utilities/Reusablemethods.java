package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.Driverinit;

public class Reusablemethods extends Driverinit{
	
	public static WebDriverWait getWDWait() {
		
		return new WebDriverWait(getDriver(),10);
	}
	
	
}
