package org.sample.automation.pages;

import org.openqa.selenium.WebDriver;
import org.sample.automation.browserutils.Locator;
import org.sample.automation.browserutils.SeleniumUtil;

/**
 * @author arunkumar
 * 
 * The Class LoginPage - Page Object Model class for Circles.life login page
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class LoginPage {
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator signinBlock = new Locator("xpath", "//span[text()='SIGN IN']", "Signin block");
	private Locator emailAddressField = new Locator("name", "email", "Email address field in signin page");
	private Locator passwordField = new Locator("name", "password", "Password field in signin page");
	private Locator signinButton = new Locator("xpath", "//button[text()='Sign In']", "Signin button in Sign In page");

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 * Verify user is in sign in page.
	 *
	 * @return true, if successful
	 */
	public boolean verifyUserIsInSigninPage() {
		seleniumUtil.waitForElementToBeDisplayed(signinBlock, 10);
		try {
			return driver.findElement(signinBlock.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	/**
	 * Login to application.
	 *
	 * @param username the username
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void loginToApplication(String username, String password) throws Exception {
		seleniumUtil.enterText(emailAddressField, username);
		seleniumUtil.enterText(passwordField, password);
		seleniumUtil.click(signinButton);
	}
	
	/**
	 * Verify sign in success.
	 *
	 * @return true, if successful
	 */
	public boolean verifySigninSuccess() {
		seleniumUtil.waitForElementToDisappear(signinBlock, 10);
		try {
			return !driver.findElement(signinBlock.getBy()).isDisplayed();
		} catch(Exception exception) {
			return true;
		}
		
	}
}
