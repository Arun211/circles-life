package com.circles.automation.pages;

import org.apache.log4j.Logger;
import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;

/**
 * @author arunkumar
 * 
 * The Class UserHomePage - Page Object Model class for Circles.life user home page after successful login.
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class UserHomePage {
	private static final Logger LOGGER = Logger.getLogger(UserHomePage.class);
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator myaccountLink = new Locator("xpath", "//a[@class='Links']//div[text()='MY ACCOUNT']", "My account link");
	private Locator emailField = new Locator("xpath", "//label[text()='Email']//following-sibling::div//input", "User email in account page");
	
	/**
	 * Instantiates a new user home page.
	 *
	 * @param driver the driver
	 */
	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 * Verify user home page displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyUserHomePageDisplayed() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(myaccountLink, 15);
			return driver.findElement(myaccountLink.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	/**
	 * Navigate to my account.
	 */
	public void navigateToMyAccount() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(myaccountLink, 15);
			seleniumUtil.click(myaccountLink);
		} catch(Exception exception) {
			LOGGER.error("Exception while navigating to My Account - "+exception.getMessage());
		}
	}
	
	/**
	 * Gets the email from My Account page to verify.
	 *
	 * @return the email
	 */
	public String getEmail() {
		seleniumUtil.waitForElementToBeDisplayed(emailField, 15);
		return driver.findElement(emailField.getBy()).getAttribute("value");
	}
}
