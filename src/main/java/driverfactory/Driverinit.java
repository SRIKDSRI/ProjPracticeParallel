package driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverinit {
	
public static Properties prop;
public static final Logger log = LogManager.getLogger(Driverinit.class);
private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

	public static WebDriver init() {
	
		try {
	FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties.properties");	
	prop = new Properties();
	prop.load(fi);
	log.info("properties file loaded successfully");
	}
		catch(IOException e) {
			log.error("Something wrong with the path defined");
		}
	if(prop.getProperty("browser").equals("chrome")) {
	 WebDriverManager.chromedriver().setup();
		tl.set(new ChromeDriver());
		log.info("Chrome driver has been set successfully");
		tl.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else {
			log.error("invalid browser name provided");
		}
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	 return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		return tl.get();
	}

}
