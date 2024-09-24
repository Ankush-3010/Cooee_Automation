package org.cooee;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class iOSBaseTest extends AppiumUtils{
	public AppiumDriverLocalService service;
	public AppiumDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	@Parameters({"platformName", "deviceName", "platformVersion", "app"})
	public void configureAppium(String platformName, String deviceName, String platformVersion, String app) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("platformName", platformName);
		ltOptions.put("deviceName", deviceName);
		ltOptions.put("platformVersion", platformVersion);
		ltOptions.put("app", app);
		ltOptions.put("isRealMobile", true);
		ltOptions.put("autoGrantPermissions", true);
		ltOptions.put("automationName", "flutter");
		capabilities.setCapability("lt:options", ltOptions);


		// Initialize the Android driver
		driver = new AppiumDriver(new URL("https://ankush.bobade:85tSKKEr9JHkh2ZaWIA1SFJfYNRtlB1NgIVqzc6wfNSv7LBTJ3@mobile-hub.lambdatest.com/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		//service.stop();

	}
}
