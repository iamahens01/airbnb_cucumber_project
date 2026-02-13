package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;
	
	public static void initializeBrowser() {
		driver= DriverFactory.initDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void quitBrowser() {
		DriverFactory.quitDriver();
	}
	
	

}
