package com.circles.facebook.pages;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;

/**
 * @author arunkumar
 * 
 * The Class FacebookLoginPage - Page Object Model class for Facebook website login page.
 * 
 * Note - Description for locator object is given in Locator object initialization
 */
public class FacebookLoginPage {
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator emailAddressField = new Locator("id", "email", "Email address field in login page");
	private Locator passwordField = new Locator("id", "pass", "Password field in login page");
	private Locator loginButton = new Locator("xpath", "//label[@id='loginbutton']/input", "Login button in login page");

	/**
	 * Instantiates a new facebook login page.
	 *
	 * @param driver the driver
	 */
	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(this.driver);
	}
	
	/**
	 * Logins to Facebook.
	 *
	 * @param email the email
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void loginToFacebook(String email, String password) throws Exception {
		seleniumUtil.enterText(emailAddressField, email);
		seleniumUtil.enterText(passwordField, password);
		seleniumUtil.click(loginButton);
	}
}
