package org.cooee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SkyPeLogin {

	public WebDriver webDriver;
	public void openSkypeWebsite() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ankush\\eclipse-workspace\\CooeeAutomation\\src\\test\\java\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// Disable notifications
		options.addArguments("--disable-notifications");
		// Or use preferences to disable notifications
		java.util.Map<String, Object> prefs = new java.util.HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1); // 1 is for allowing notification and 2
																				// for not allowing
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1); // 1 to allow
		options.setExperimentalOption("prefs", prefs);

		webDriver = new ChromeDriver(options);

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get("https://www.skype.com/en/");
	}

}
