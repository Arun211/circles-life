package org.circles.automation.browserutils;

import io.appium.java_client.android.AndroidDriver;

import org.circles.automation.utils.ReadProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author arunkumar
 * 
 * A factory for creating Browser objects.
 * 
 * Supports creating Firefox, Chrome and Android driver.
 */
public class BrowserFactory {
	
	private static ReadProperty readProperty;
	private static String applicationName;
	
	/**
	 * Static block initializes readProperty object to fetch data from properties file.
	 */
	static {
		readProperty = new ReadProperty();
	}
	
	/**
	 * Creates a new Browser object.
	 *
	 * @param browserName the browser name
	 * @param applicationName the application name
	 * @return the web driver
	 */
	public static WebDriver createBrowserDriver(String browserName, String applicationName) {
		BrowserFactory.applicationName = applicationName;
		
		switch(browserName.toLowerCase()){
			case "firefox":
				return createFirefoxDriver();
			case "chrome":
			case "googlechrome":
				return createChromeDriver();
			case "android":
				return createAndroidDriver();
			default:
				return null;
		}
	}
	
	/**
	 * Creates a new Chrome browser object and opens the application given in properties file.
	 *
	 * @return the Chrome webdriver object
	 */
	private static WebDriver createChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", readProperty.getValue("CHROME_DRIVER_PATH"));
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(readProperty.getValue(BrowserFactory.applicationName));
		return driver;
	}
	
	/**
	 * Creates a new Firefox browser object.
	 *
	 * @return the Firefox webdriver object
	 */
	private static WebDriver createFirefoxDriver() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addPreference("dom.webnotifications.serviceworker.enabled", false);
		firefoxOptions.addPreference("dom.webnotifications.enabled", false);
		
		System.setProperty("webdriver.gecko.driver", readProperty.getValue("FIREFOX_DRIVER_PATH"));
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
		driver.manage().window().maximize();
		driver.get(readProperty.getValue(BrowserFactory.applicationName));
		return driver;
	}
	
	/**
	 * Creates a new Android browser object.
	 *
	 * @return the Android webdriver
	 */
	private static WebDriver createAndroidDriver() {
		WebDriver driver = new AndroidDriver(DesiredCapabilities.android());
		return driver;
	}
}
