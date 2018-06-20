package com.sample.facebook.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

import org.sample.automation.browserutils.Locator;
import org.sample.automation.browserutils.SeleniumAndroidUtil;

/**
 * @author arunkumar
 * 
 * FacebookAppLoginPage class - Page Object Model class for Facebook App login page.
 * 
 * Note - Description for locator object is given in Locator object initialization
 */
public class FacebookAppLoginPage {
	
	private AppiumDriver<MobileElement> driver;
	private SeleniumAndroidUtil seleniumAndroidUtil;
	
	private Locator emailAddressField = new Locator("xpath", "//android.widget.EditText[contains(@text,'Email or Phone')]", "Email address field");
	private Locator allTextFields = new Locator("xpath", "//android.widget.EditText", "Password field");
	private Locator loginButton = new Locator("xpath", "//android.widget.Button[contains(@text,'LOG IN')]", "Login button");
	
	private Locator notNowButton = new Locator("xpath", "//android.widget.Button[contains(@text,'Not Now')]", "Not now button");

	/**
	 * Instantiates a new Facebook app login page object.
	 *
	 * @param driver the driver
	 */
	public FacebookAppLoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		seleniumAndroidUtil = new SeleniumAndroidUtil(driver);
	}
	
	/**
	 * Logins to Facebook app.
	 *
	 * @param email the email
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void loginToFacebook(String email, String password) throws Exception {
		seleniumAndroidUtil.enterText(emailAddressField, email);
		List<MobileElement> textFields = driver.findElements(allTextFields.getBy());
		for(MobileElement element: textFields) {
			if(element.getAttribute("password").trim().equalsIgnoreCase("true")) {
				element.click();
				element.sendKeys(password);
				break;
			}
		}
		seleniumAndroidUtil.click(loginButton);
		seleniumAndroidUtil.clickIfDisplayed(notNowButton);
	}
}
