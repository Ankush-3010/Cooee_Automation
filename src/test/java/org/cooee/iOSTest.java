package org.cooee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.cooee.pageObjects.ios.CallPage;
import org.cooee.pageObjects.ios.HomePage;
import org.cooee.pageObjects.android.IncomingCallPage;
import org.cooee.pageObjects.ios.LogInPage;
import org.cooee.pageObjects.ios.SignupAndLoginScreenPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class iOSTest extends iOSBaseTest {

	SignupAndLoginScreenPage signupAndLoginScreenPage;
	LogInPage logInPage;
	HomePage homePage;
//	IncomingCallPage incomingCall;
	CallPage callPage;
	
	@BeforeMethod
	public void setUp() {
		signupAndLoginScreenPage = new SignupAndLoginScreenPage(driver);
		logInPage = new LogInPage(driver);
	//	homePage = new HomePage(driver);
	//	incomingCall = new IncomingCallPage(driver);
		callPage = new CallPage(driver);
	}

	@Test(dataProvider = "getData", priority = 1)
	public void OutBoundCall(HashMap< String, String> input) throws InterruptedException {

		signupAndLoginScreenPage.setSignInWithEmail();
		logInPage.setEmail(input.get("email"));
		logInPage.setPassword(input.get("password"));
		logInPage.clickLoginButton();
		callPage.clickDialPadButton();
		callPage.selectCallViaDropdown();
		//System.out.println(input.get("number"));
		callPage.enterNumber(input.get("number"));

		callPage.dialAndEndCall();
	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\cooee\\testData\\testdata.json");
		return new Object[][] {{data.get(0)}};
	}


}
