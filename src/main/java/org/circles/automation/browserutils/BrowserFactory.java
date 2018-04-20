package org.circles.automation.browserutils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.circles.automation.utils.ReadProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	private static ReadProperty readProperty;
	
	static {
		readProperty = new ReadProperty();
	}
	
	public static WebDriver createChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", readProperty.getValue("CHROME_DRIVER_PATH"));
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(readProperty.getValue("APPLICATION_URL"));
		return driver;
	}
	
	public static WebDriver createFirefoxDriver() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--disable-notifications");
		firefoxOptions.addPreference("dom.webnotifications.serviceworker.enabled", false);
		firefoxOptions.addPreference("dom.webnotifications.enabled", false);
		
		System.setProperty("webdriver.gecko.driver", readProperty.getValue("FIREFOX_DRIVER_PATH"));
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
		driver.manage().window().maximize();
		driver.get(readProperty.getValue("APPLICATION_URL"));
		return driver;
	}
	
	public static WebDriver createAndroidDriver() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		service.stop();
		WebDriver driver = new AndroidDriver(DesiredCapabilities.android());
		return driver;
	}
}
