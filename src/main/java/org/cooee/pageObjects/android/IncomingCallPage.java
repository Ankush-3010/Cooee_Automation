package org.cooee.pageObjects.android;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IncomingCallPage {
	

	AppiumDriver driver;
	AppiumUtils appiumUtils;

	public IncomingCallPage(AppiumDriver driver) {
		
		this.driver = driver;
		this.appiumUtils = new AppiumUtils();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	
	@AndroidFindBy(accessibility = ("Accept"))
	private WebElement acceptCallButton;
	
	@AndroidFindBy(accessibility = ("Decline"))
	private WebElement rejectCallButton;
	
	public void AcceptCall() throws InterruptedException 
	{
		
		acceptCallButton.click();
		
		 WebElement acceptCallButtonElement = appiumUtils.waitForVisibility(acceptCallButton, 40, driver);
		 acceptCallButtonElement.click();
		Thread.sleep(20000);

	}
	
	public void RejectCall() throws InterruptedException 
	{
		Thread.sleep(10000);
		rejectCallButton.click();

	}
	

}
