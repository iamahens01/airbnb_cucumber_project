package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private static Properties properties;
 
static {
	try {
		properties = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Sneha.Saxena\\eclipse-workspace\\projectCucumberAirbnb\\src\\main\\java\\resources\\config.properties");
		properties.load(file);
		
	}
	catch(IOException e) {
		throw new RuntimeException("Failed to load config.properties file", e);
	}
}

public static String getProperty(String key) {
	String value = properties.getProperty(key);
	
	if(value == null) {
		throw new RuntimeException("key not found in config.properties" + key);

	}
	
	return value.trim();
	
}

}
