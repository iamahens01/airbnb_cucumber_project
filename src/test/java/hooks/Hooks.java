package hooks;

import java.io.IOException;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before 
	public void setUp() {
		BaseTest.initializeBrowser();
		
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException{
		
		if(scenario.isFailed()) {
			System.out.println("Scenario Failed"+ scenario.getName());
			
		}
		
		BaseTest.quitBrowser();
		
	}

}
