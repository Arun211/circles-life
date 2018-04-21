package com.circles.automation.tests;

import org.apache.log4j.Logger;
import org.circles.automation.browserutils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.circles.facebook.pages.FacebookLoginPage;
import com.circles.facebook.pages.FacebookUserHomePage;

/**
 * @author arunkumar
 * 
 * The Class FacebookPostTests.
 */
public class FacebookPostTests {
	private static final Logger LOGGER = Logger.getLogger(FacebookPostTests.class);
	
	public WebDriver driver;
	
	public FacebookLoginPage facebookLoginPage;
	public FacebookUserHomePage facebookUserHomePage;
	
	/**
	 * Initialize the browser driver from BrowserFactory;
	 * Creates required page objects to be used inside test script.
	 * 
	 */
	@BeforeClass
	public void initBrowserDriver() {
		driver = BrowserFactory.createBrowserDriver("Chrome", "FACEBOOK_URL");
		facebookLoginPage = new FacebookLoginPage(driver);
		facebookUserHomePage = new FacebookUserHomePage(driver);
	}
	
	/**
	 * Retrieve login credentials and post message from Test Data source for facebook website login;
	 * hard-coded in our test scripts(Just for sample).
	 *
	 * @return the login credentials and message to post
	 * 
	 * Note:- Test data source can be xls, csv, json, YAML, databases etc...
	 */
	@DataProvider
	public String[][] getLoginCredentials() {
		String[][] loginCredentials = {{"taskscircles.life@gmail.com", "Seniorqa1", "First Test Post"}};
		return loginCredentials;
	}
	
	/**
	 * Post the given message in Facebook wall.
	 * 
	 * 1. Login to Facebook and verify user is logged in
	 * 2. Publish given message as post
	 *
	 * @param email - email to login
	 * @param password - password to login
	 * @param postMessage - message to post
	 * @throws Exception the exception
	 */
	@Test(dataProvider="getLoginCredentials")
	public void post(String email, String password, String postMessage) throws Exception {
		facebookLoginPage.loginToFacebook(email, password);
		Assert.assertTrue(facebookUserHomePage.isUserLoggedIn(), "User not logged in, profile picture not displayed.");
		
		facebookUserHomePage.publishPost(postMessage);
	}
	
	/**
	 * Close browser driver.
	 */
	@AfterClass
	public void closeBrowserDriver() {
		try {
			driver.quit();
		} catch(Exception exception) {
			LOGGER.error("Exception while closing browser driver after test execution -"+exception.getMessage());
		}
	}
	
}
