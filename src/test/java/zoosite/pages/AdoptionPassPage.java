package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.AdoptionPassLocators;
import zoosite.util.Base;

public class AdoptionPassPage extends Base{
	
	Properties prop;
	
	public AdoptionPassPage(WebDriver browser, Properties prop){
		super(browser);
		this.prop=prop;
	}

	public void enterDetails(){
		browser.findElement(AdoptionPassLocators.name).sendKeys(prop.getProperty("name"));
		browser.findElement(AdoptionPassLocators.address).sendKeys(prop.getProperty("address"));
		browser.findElement(AdoptionPassLocators.postcode).sendKeys(prop.getProperty("postcode"));
		browser.findElement(AdoptionPassLocators.email).sendKeys(prop.getProperty("email"));
	}
	
	public AdoptionConfirmPage submitDetails(){
		browser.findElement(AdoptionPassLocators.submitAdoption).click();
		return new AdoptionConfirmPage(browser,prop);
	}
}
