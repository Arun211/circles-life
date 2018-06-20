package org.sample.automation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sample.automation.browserutils.BrowserFactory;
import org.sample.automation.pages.HomePage;
import org.sample.automation.pages.LoginPage;
import org.sample.automation.pages.UserHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author arunkumar
 * 
 * The Class CirclesEmailVerificationTests.
 */
public class CirclesEmailVerificationTests {
	private static final Logger LOGGER = Logger.getLogger(CirclesEmailVerificationTests.class);
	
	public WebDriver driver;
	
	public HomePage homePage;
	public LoginPage loginPage;
	public UserHomePage userHomePage;
	
	/**
	 * Initialize the browser driver from BrowserFactory;
	 * Creates required page objects to be used inside test script.
	 * 
	 */
	@BeforeClass
	public void initBrowserDriver() {
		driver = BrowserFactory.createBrowserDriver("Chrome", "CIRCLES_URL");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		userHomePage = new UserHomePage(driver);
	}
	
	/**
	 * Retrieve login credentials for circles.life website from Test Data source;
	 * Hard-coded in our test scripts(Just for sample).
	 *
	 * @return the login credentials
	 * 
	 * Note:- Test data source can be xls, csv, json, YAML, databases etc...
	 */
	@DataProvider
	public String[][] getLoginCredentials() {
		String[][] loginCredentials = {{"taskscircles.life@gmail.com","Seniorqa@"}};
		return loginCredentials;
	}
	
	/**
	 * Verify email in my account page is displayed as expected after successful login.
	 *  
	 * 1. Navigate to sign in page and verify sign in page is displayed
	 * 2. Login to application and verify user home after login is displayed
	 * 3. Navigate to my account and verify email is displayed as expected
	 * 
	 * @param username - username to login
	 * @param password - password to login
	 * @throws Exception the exception
	 */
	@Test(dataProvider="getLoginCredentials")
	public void verifyEmailAfterLogin(String username, String password) throws Exception {
		homePage.moveToSignInPage();
		Assert.assertTrue(loginPage.verifyUserIsInSigninPage(), "User is not in Signin page");
		
		loginPage.loginToApplication(username, password);
		Assert.assertTrue(userHomePage.verifyUserHomePageDisplayed(), "Signin failed, User home page is not displayed");
		
		userHomePage.navigateToMyAccount();
		String actualEmail = userHomePage.getEmail();
		Assert.assertEquals(actualEmail, username, actualEmail+" is different from expected email "+username);
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
