package org.cooee.pageObjects.ios;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CallPage {
	AppiumDriver driver;
	AppiumUtils appiumUtils;

	public CallPage(AppiumDriver driver) {

		this.driver = driver;
		this.appiumUtils = new AppiumUtils();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}


	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
	private WebElement dialPadButton;

	@iOSXCUITFindBy(accessibility = "Call via\nUK\n+447418626304")
	private WebElement callViaDropdown;

	@iOSXCUITFindBy(accessibility = "US\n+14695650141")
	private WebElement selectCall;

	@iOSXCUITFindBy( iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]")
	private WebElement numberField;

	@iOSXCUITFindBy(accessibility = "0")
	private WebElement keyPad0;
	@iOSXCUITFindBy(accessibility = "1")
	private WebElement keyPad1;
	@iOSXCUITFindBy(accessibility = "2")
	private WebElement keyPad2;
	@iOSXCUITFindBy(accessibility = "3")
	private WebElement keyPad3;
	@iOSXCUITFindBy(accessibility = "4")
	private WebElement keyPad4;
	@iOSXCUITFindBy(accessibility = "5")
	private WebElement keyPad5;
	@iOSXCUITFindBy(accessibility = "6")
	private WebElement keyPad6;
	@iOSXCUITFindBy(accessibility = "7")
	private WebElement keyPad7;
	@iOSXCUITFindBy(accessibility = "8")
	private WebElement keyPad8;
	@iOSXCUITFindBy(accessibility = "9")
	private WebElement keyPad9;

	@iOSXCUITFindBy(iOSClassChain =  "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[14]")
	private WebElement dialButton;

	@iOSXCUITFindBy(iOSClassChain =  "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
	private WebElement rejectbutton;



	public void clickDialPadButton() throws InterruptedException {
		Thread.sleep(2000);
		WebElement dialPadElement = appiumUtils.waitForVisibility(dialPadButton, 10, driver);
		dialPadElement.click();
	}

	public void selectCallViaDropdown() throws InterruptedException {
		callViaDropdown.click();
		selectCall.click();
	}


	public void enterNumber(String number) throws InterruptedException {
		numberField.click();
		keyPad5.click();
		keyPad0.click();
		keyPad3.click();
		keyPad4.click();
		keyPad0.click();
		keyPad1.click();
		keyPad9.click();
		keyPad9.click();
		keyPad9.click();
		keyPad1.click();
		numberField.sendKeys(number);
	}

	public void dialAndEndCall() throws InterruptedException {		
		dialButton.click();
		Thread.sleep(20000);
		rejectbutton.click();
	}

}
