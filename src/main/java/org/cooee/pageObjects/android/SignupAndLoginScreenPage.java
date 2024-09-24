package org.cooee.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignupAndLoginScreenPage {

	AppiumDriver driver;
	
	public SignupAndLoginScreenPage(AppiumDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	
	
	@AndroidFindBy(accessibility="Sign in with Email and Password")
	private WebElement signInWithEmail;
	
	public  void setSignInWithEmail() throws InterruptedException
	{
		
		signInWithEmail.click();
		Thread.sleep(3000);
		
	}
}
