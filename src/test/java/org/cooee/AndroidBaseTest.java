package org.cooee;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.cooee.utils.AppiumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils {
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
		ltOptions.put("autoAcceptAlerts", true);
	//	ltOptions.put("network", "true"); 
	//	ltOptions.put("automationName", "flutter");
		capabilities.setCapability("lt:options", ltOptions);


		// Initialize the Android driver
		driver = new AppiumDriver(new URL("https://ankush.bobade:85tSKKEr9JHkh2ZaWIA1SFJfYNRtlB1NgIVqzc6wfNSv7LBTJ3@mobile-hub.lambdatest.com/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		//service.stop();

	}

}

//Build the Appium service

		//		  service = new AppiumServiceBuilder() .withAppiumJS( new File(
		//		  "C:\\Users\\Ankush\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
		//		  )) .withIPAddress("127.0.0.1").usingPort(4723).build();
		//		 
		//		// Start the Appium server
		//		// service.start();
		//		// Set capabilities for the Android driver
		//		
		//		UiAutomator2Options options = new UiAutomator2Options();
		//			options.setDeviceName("Pixel 6 API 34");
		//			options.setChromedriverExecutable("C:\\Users\\Ankush\\eclipse-workspace\\CooeeApp\\src\\test\\java\\resources\\chromedriver.exe");
		//			options.setApp("C:\\Users\\Ankush\\eclipse-workspace\\CooeeAutomation\\src\\test\\java\\resources\\cooee6Aug24.apk");
		//			options.setCapability("appPackage", "com.cooee2test.callcooee");
		//			options.setCapability("appActivity", "com.cooee2test.callcooee.MainActivity");
		//			options.setCapability("autoGrantPermissions", true);a