package org.cooee.pageObjects.ios;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LogInPage {

	    AppiumDriver driver;
	    AppiumUtils appiumUtils;

	    public LogInPage(AppiumDriver driver) {
	        this.driver = driver;
	        this.appiumUtils = new AppiumUtils();
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Email'`]")
	    private WebElement emailBox;

	    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Password'`]")
	    private WebElement passwordBox;

	    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Log In'`]")
	    private WebElement logInButton;

	    public void setEmail(String email) {
	        // Use the correct method name waitForVisibility from AppiumUtils
	        WebElement emailElement = appiumUtils.waitForVisibility(emailBox, 10, driver);
	        emailElement.click();
	        emailElement.sendKeys(email);
	    }

	    public void setPassword(String password) {
	        WebElement passwordElement = appiumUtils.waitForVisibility(passwordBox, 10, driver);
	        passwordElement.click();
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        WebElement loginButtonElement = appiumUtils.waitForVisibility(logInButton, 10, driver);
	        loginButtonElement.click();
	    }


}
