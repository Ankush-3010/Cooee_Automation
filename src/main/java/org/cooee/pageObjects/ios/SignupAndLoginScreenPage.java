package org.cooee.pageObjects.ios;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignupAndLoginScreenPage {

	AppiumDriver driver;
	AppiumUtils appiumUtils;

	public SignupAndLoginScreenPage(AppiumDriver driver) {
		this.driver = driver;
		this.appiumUtils = new AppiumUtils();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(accessibility = "Sign in with Email and Password")
	private WebElement signInWithEmail;

	public  void setSignInWithEmail() throws InterruptedException
	{

		signInWithEmail.click();
		Thread.sleep(3000);

	}
}
