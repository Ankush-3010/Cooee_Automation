package org.cooee.pageObjects.android;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogInPage {

    AppiumDriver driver;
    AppiumUtils appiumUtils;

    public LogInPage(AppiumDriver driver) {
        this.driver = driver;
        this.appiumUtils = new AppiumUtils();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    private WebElement emailBox;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    private WebElement passwordBox;

    @AndroidFindBy(accessibility = "Log In")
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
