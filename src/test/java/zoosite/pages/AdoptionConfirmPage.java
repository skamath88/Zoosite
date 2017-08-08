package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.AdoptionConfirmPageLocators;
import zoosite.util.Base;

public class AdoptionConfirmPage extends Base{
	
	Properties prop;
	
	public AdoptionConfirmPage(WebDriver browser, Properties prop){
		super(browser);
		this.prop =prop;
	}
	
	public String getSuccesMessage(){
		return browser.findElement(AdoptionConfirmPageLocators.message).getText();
	}

}
