package org.cooee.pageObjects.android;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CallPage {
	AppiumDriver driver;
	AppiumUtils appiumUtils;

	public CallPage(AppiumDriver driver) {

		this.driver = driver;
		this.appiumUtils = new AppiumUtils();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}


	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[6]")
	private WebElement dialPadButton;
	
    @AndroidFindBy(accessibility = "Call via\nUK\n+447418626304")
	private WebElement callViaDropdown;
    
    @AndroidFindBy(accessibility = "US\n+14695650141")
    private WebElement selectCall;

	@AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
	private WebElement numberField;
	
	@AndroidFindBy(accessibility = "0")
    private WebElement keyPad0;
	@AndroidFindBy(accessibility = "1")
    private WebElement keyPad1;
	@AndroidFindBy(accessibility = "2")
    private WebElement keyPad2;
	@AndroidFindBy(accessibility = "3")
    private WebElement keyPad3;
	@AndroidFindBy(accessibility = "4")
    private WebElement keyPad4;
	@AndroidFindBy(accessibility = "5")
    private WebElement keyPad5;
	@AndroidFindBy(accessibility = "6")
    private WebElement keyPad6;
	@AndroidFindBy(accessibility = "7")
    private WebElement keyPad7;
	@AndroidFindBy(accessibility = "8")
    private WebElement keyPad8;
	@AndroidFindBy(accessibility = "9")
    private WebElement keyPad9;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[16]")
	private WebElement dialButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")
	private WebElement rejectbutton;



	public void clickDialPadButton() throws InterruptedException {
		WebElement dialPadElement = appiumUtils.waitForVisibility(dialPadButton, 20, driver);
		dialPadElement.click();
	}
	
	public void selectCallViaDropdown() throws InterruptedException {
		callViaDropdown.click();
		selectCall.click();
	}

	 public void enterNumber(String phoneNumber) throws InterruptedException {
	        numberField.click();
	        for (char digit : phoneNumber.toCharArray()) {
	            switch (digit) {
	                case '0':
	                    keyPad0.click();
	                    break;
	                case '1':
	                    keyPad1.click();
	                    break;
	                case '2':
	                    keyPad2.click();
	                    break;
	                case '3':
	                    keyPad3.click();
	                    break;
	                case '4':
	                    keyPad4.click();
	                    break;
	                case '5':
	                    keyPad5.click();
	                    break;
	                case '6':
	                    keyPad6.click();
	                    break;
	                case '7':
	                    keyPad7.click();
	                    break;
	                case '8':
	                    keyPad8.click();
	                    break;
	                case '9':
	                    keyPad9.click();
	                    break;
	            }
	        }
	    }


	public void dialAndEndCall() throws InterruptedException {		
		dialButton.click();
		Thread.sleep(20000);
		rejectbutton.click();
	}

}
