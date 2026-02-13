package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


import utils.ConfigReader;

public class DriverFactory {
	
	private static WebDriver driver;
	public static WebDriver initDriver() {
		String browser = ConfigReader.getProperty("browser");
		
		switch(browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		
	   case "edge":
		driver = new EdgeDriver();
		break;
		
		default:
			throw new RuntimeException("Browser not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		driver.get(ConfigReader.getProperty("url"));
		
		return driver;
				
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void quitDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
	
	}


