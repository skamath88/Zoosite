package zoosite.steps;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import zoosite.pages.AdoptionConfirmPage;
import zoosite.pages.AdoptionPage;
import zoosite.pages.AdoptionPassPage;
import zoosite.pages.ZooHomePage;

public class AnimalAdoption {
	
	Properties prop = new Properties();
	WebDriver browser = null;
	ZooHomePage homePage;
	AdoptionPage adoptPage;
	AdoptionPassPage adoptPassPage;
	AdoptionConfirmPage adoptConfirmPage;
	
	@Given("^I am on the home page of Zoo site$")
	public void openZooSite() throws Throwable {

	   FileInputStream fis = new FileInputStream("C:\\Users\\Satish Kamat\\workspace2\\Zoosite\\src\\test\\java\\zoosite\\util\\data.properties");
	   prop.load(fis);
	   
	   System.setProperty("webdriver.chrome.driver", "C:/Users/Satish Kamat/workspace1/chromedriver.exe");
	   browser = new ChromeDriver();
	   browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   browser.navigate().to(prop.getProperty("url"));
	   homePage = new ZooHomePage(browser,prop);
   
	}

	@And("^I adopt an animal$")
	public void adoptAnimal() throws Throwable {
		
		adoptPassPage.enterDetails();
		adoptConfirmPage = adoptPassPage.submitDetails();
	    
	}
	
	@When("^I goto Adoption page and check foravailability$")
	public void gotoAdoptionpageCheckAvailability() throws Throwable {
		   adoptPage= homePage.navigateToAdoption();
		   adoptPage.selectStartDate();
		   adoptPassPage = adoptPage.checkAvailability();
		   
	}

	@Then("^I should see the message \"([^\"]*)\"$")
	public void verifyAdoptionMessage(String successMessage) throws Throwable {
		
		  String actual= adoptConfirmPage.getSuccesMessage().toLowerCase();  
		  Assert.assertEquals(successMessage, actual);
		  adoptConfirmPage.closeBrowser();
	}


}
