package parallel;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Reusablemethods;

public class Hooks extends Reusablemethods{

	
	@Before
	public void setUp() throws IOException {
	
		init().get(prop.getProperty("url"));
	}
	
	@After(order=1)
	public void tearDown() {
		
		getDriver().quit();
	}
	
	@After(order=2)
	public void takeScreenshot(Scenario scenario) {
		byte[] bytes = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		String screenshotname = scenario.getName().replaceAll("", "_");
		scenario.attach(bytes, "image/png", screenshotname);
	}
	
	
}
