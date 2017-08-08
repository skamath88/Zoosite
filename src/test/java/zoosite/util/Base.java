package zoosite.util;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;

public class Base {
	
	protected WebDriver browser;
	
	public Base(WebDriver browser){
		this.browser=browser;
	}
	
	public void closeBrowser(){
		browser.quit();
	}

}
