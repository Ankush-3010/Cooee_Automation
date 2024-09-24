package org.cooee.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoggedInPage {
	
	AndroidDriver driver;
	public LoggedInPage(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@AndroidFindBy(accessibility="logged Username: jc6MANc1 ")
	private WebElement loggedIn;
	
	public String getUsernameText() throws InterruptedException
	{
		String username = loggedIn.getAttribute("content-desc");
		return username;	
	}
}
