package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.HomePageLocators;
import zoosite.util.Base;

public class ZooHomePage extends Base {
	
	Properties prop;

	public ZooHomePage(WebDriver browser, Properties prop) {
		super(browser);
		this.prop =prop;
	}

	public AdoptionPage navigateToAdoption(){
		browser.findElement(HomePageLocators.adoption).click();
		return new AdoptionPage(browser,prop);
	}

}
