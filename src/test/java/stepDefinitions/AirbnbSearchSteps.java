package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.*;



public class AirbnbSearchSteps {
	
	WebDriver driver = BaseTest.getDriver();
	@Given("User launches the Airbnb application")
	public void user_launches_the_airbnb_application() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Airbnb launched susccessfully");
	}
	@When("User enters location")
	public void user_enters_location() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		By searchLocator= By.xpath("//input[@placeholder='Search destinations']");
		
		WebElement searchBox= wait.until(ExpectedConditions.elementToBeClickable(searchLocator));
		
		searchBox.click();
		searchBox.sendKeys("Delhi");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		


		//		WebElement searchBox;
// searchBox= driver.findElement(By.xpath("//input[@placeholder='Search destinations']"));
// searchBox.click();
// Thread.sleep(3000);
// searchBox.sendKeys("delhi");
}
	@When("User selects check-in and check-out dates")
	public void user_selects_check_in_and_check_out_dates() throws InterruptedException {
	
		Thread.sleep(3000);
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//*[text()='When']")).click();
		
		Thread.sleep(3000);
		
		
		
		
           driver.findElement(By.xpath("//*[@data-state--date-string='2026-03-08']")).click();
   		Thread.sleep(3000);



           driver.findElement(By.xpath("//*[@data-state--date-string='2026-03-19']")).click();
           Thread.sleep(3000);
	}
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("Search results page should be displayed")
	public void search_results_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   String currentUrl= driver.getCurrentUrl();	
		if(!currentUrl.contains("s/")) {
			throw new RuntimeException("Search successful");
		}
		System.out.println("search result");
				

	}
}

