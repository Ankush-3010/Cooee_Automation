package org.cooee.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AppiumDriver driver;

	public HomePage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(accessibility = "Home\nTab 3 of 5")
	private WebElement homeButton;

	@AndroidFindBy(accessibility = "Login for VOIP call")
	private WebElement loginVOIPButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement destinationBox;

	@AndroidFindBy(accessibility = "Call")
	private WebElement callButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")
	private WebElement rejectButton;

	public void clickHomeButton() throws InterruptedException {
		Thread.sleep(5000);
		homeButton.click();
	}

	public void clickLoginVOIPButton() throws InterruptedException {
		Thread.sleep(2000);
		loginVOIPButton.click();
	}

	public void setDestinationNumber(String number) {

		destinationBox.click();
		destinationBox.sendKeys(number);
	}

	public void clickCallButton() {

		callButton.click();
	}

	public void clickRejectButton() throws InterruptedException {

		Thread.sleep(10000);
		rejectButton.click();
	}

}
