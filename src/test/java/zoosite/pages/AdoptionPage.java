package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import zoosite.pageelements.AdoptionPageLocators;
import zoosite.util.Base;

public class AdoptionPage extends Base {
	
	Properties prop;
	
	public AdoptionPage(WebDriver browser, Properties prop) {
		super(browser);
		this.prop = prop;
	}


	public void  selectStartDate(){
		Select startDateBox = new Select(browser.findElement(AdoptionPageLocators.startDate));
		startDateBox.selectByValue(prop.getProperty("startDate"));
	}
	
	public AdoptionPassPage checkAvailability(){
		browser.findElement(AdoptionPageLocators.selectAnimal).click();
		return new AdoptionPassPage(browser, prop);
		
	}

}
