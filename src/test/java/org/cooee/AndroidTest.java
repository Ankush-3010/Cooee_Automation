package org.cooee;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.cooee.pageObjects.android.LogInPage;
import org.cooee.pageObjects.android.CallPage;
import org.cooee.pageObjects.android.HomePage;
import org.cooee.pageObjects.android.IncomingCallPage;
import org.cooee.pageObjects.android.LoggedInPage;
import org.cooee.pageObjects.android.SignupAndLoginScreenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.HasNotifications;

public class AndroidTest extends AndroidBaseTest {

	SignupAndLoginScreenPage signupAndLoginScreenPage;
	LogInPage logInPage;
	HomePage homePage;
	IncomingCallPage incomingCall;
	CallPage callPage;

	@BeforeMethod
	public void setUp() {
		signupAndLoginScreenPage = new SignupAndLoginScreenPage(driver);
		logInPage = new LogInPage(driver);
		homePage = new HomePage(driver);
		incomingCall = new IncomingCallPage(driver);
		callPage = new CallPage(driver);
	}

	
	@Test( priority = 1)
	@Parameters({"dataIndex"})
	public void OutBoundCall(int dataIndex) throws InterruptedException, IOException {
		
		// Fetch data from the DataProvider using the dataIndex parameter
        HashMap<String, String> input = (HashMap<String, String>) getData()[dataIndex][0]; // Using the dataIndex to fetch correct data	

		signupAndLoginScreenPage.setSignInWithEmail();
		logInPage.setEmail(input.get("email"));
		logInPage.setPassword(input.get("password"));
		logInPage.clickLoginButton();
	       
		callPage.clickDialPadButton();
		callPage.selectCallViaDropdown();
		callPage.enterNumber(input.get("number"));
		callPage.dialAndEndCall();
	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\cooee\\testData\\testdata.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};	
	}

}
	
	
//	@Test(enabled = false)
//	public void InBoundCall() throws MalformedURLException, InterruptedException {
//
//		SkyPeLogin skypeLoginHelper = new SkyPeLogin();
//		skypeLoginHelper.openSkypeWebsite();
//		SkyPeLoginPage skypeLoginPage = new SkyPeLoginPage(skypeLoginHelper.webDriver);
//		SkypeCallPage skypeCallPage = new SkypeCallPage(skypeLoginHelper.webDriver);
//
//		signupAndLoginScreenPage.setSignInWithEmail();
//		logInPage.setEmail("ankush.bobade@esmagico.in");
//		logInPage.setPassword("Admin@123");
//		logInPage.clickLoginButton();
//		homePage.clickHomeButton();
//		//homePage.clickLoginVOIPButton();
//
//		// String username = loggedInPage.getUsernameText();
//		// Assert.assertEquals(username, "logged Username: jc6MANc1 ");
//
//		skypeLoginPage.clickSignInButton();
//		skypeLoginPage.setUserName("kushagra.gupta@esmagico.in");
//		skypeLoginPage.clickNext();
//		skypeLoginPage.setPassword("Kushagra@2024ms");
//		skypeLoginPage.clickSignIn();
//		skypeLoginPage.clickDecline();
//
//		skypeCallPage.openDialPad();
//		skypeCallPage.setPhoneNumber("+19316551126");
//		skypeCallPage.clickCallButton();
//
//		incomingCall.AcceptCall();
//
//		skypeCallPage.clickEndCallButton();
//
//	}

//	@Test(enabled = false)
//	public void InBoundCall() throws MalformedURLException, InterruptedException {
//
//		SkyPeLogin skypeLoginHelper = new SkyPeLogin();
//		skypeLoginHelper.openSkypeWebsite();
//		SkyPeLoginPage skypeLoginPage = new SkyPeLoginPage(skypeLoginHelper.webDriver);
//		SkypeCallPage skypeCallPage = new SkypeCallPage(skypeLoginHelper.webDriver);
//
//		signupAndLoginScreenPage.setSignInWithEmail();
//		logInPage.setEmail("ankush.bobade@esmagico.in");
//		logInPage.setPassword("Admin@123");
//		logInPage.clickLoginButton();
//		homePage.clickHomeButton();
//		//homePage.clickLoginVOIPButton();
//
//		// String username = loggedInPage.getUsernameText();
//		// Assert.assertEquals(username, "logged Username: jc6MANc1 ");
//
//		skypeLoginPage.clickSignInButton();
//		skypeLoginPage.setUserName("kushagra.gupta@esmagico.in");
//		skypeLoginPage.clickNext();
//		skypeLoginPage.setPassword("Kushagra@2024ms");
//		skypeLoginPage.clickSignIn();
//		skypeLoginPage.clickDecline();
//
//		skypeCallPage.openDialPad();
//		skypeCallPage.setPhoneNumber("+19316551126");
//		skypeCallPage.clickCallButton();
//
//		incomingCall.AcceptCall();
//
//		skypeCallPage.clickEndCallButton();
//
//	}
//	


/*
 * SignupAndLoginScreenPage signupAndLoginScreenPage = new
 * SignupAndLoginScreenPage(driver);
 * signupAndLoginScreenPage.openGoogleSignIn();
 * signupAndLoginScreenPage.termAccept(); signupAndLoginScreenPage.addAccount();
 * 
 * // Switch to WebView context Set<String> contextNames =
 * driver.getContextHandles(); for (String contextName : contextNames) { if
 * (contextName.contains("WEBVIEW")) { driver.context(contextName); break; } }
 * 
 * WebElement emailField =
 * driver.findElement(By.xpath("//input[@type='email']"));
 * emailField.sendKeys("your-email@gmail.com");
 */
