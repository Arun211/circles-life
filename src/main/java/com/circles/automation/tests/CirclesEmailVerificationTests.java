package com.circles.automation.tests;

import org.circles.automation.browserutils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circles.automation.pages.HomePage;
import com.circles.automation.pages.LoginPage;
import com.circles.automation.pages.UserHomePage;

public class CirclesEmailVerificationTests {
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public UserHomePage userHomePage;
	
	@BeforeClass
	public void initBrowserDriver() {
		driver = BrowserFactory.createChromeDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		userHomePage = new UserHomePage(driver);
	}
	
	@Test
	public void verifyEmailAfterLogin() throws Exception {
		String expectedEmail = "taskscircles.life@gmail.com";
		
		homePage.moveToSignInPage();
		Assert.assertTrue(loginPage.verifyUserIsInSigninPage(), "User is not in Signin page");
		
		loginPage.loginToApplication();
		Assert.assertTrue(userHomePage.verifyUserHomePageDisplayed(), "Signin failed, User home page is not displayed");
		
		userHomePage.navigateToMyAccount();
		String actualEmail = userHomePage.getEmail();
		System.out.println("Actual Email - " + actualEmail);
		Assert.assertEquals(actualEmail, expectedEmail, actualEmail+" is different from expected email "+expectedEmail);
	}
	
	@AfterClass
	public void closeBrowserDriver() {
		try {
			driver.quit();
		} catch(Exception exception) {
			
		}
	}
}
