package com.circles.automation.tests;

import org.circles.automation.browserutils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circles.facebook.pages.FacebookLoginPage;
import com.circles.facebook.pages.FacebookUserHomePage;

public class FacebookPostTests {
	public WebDriver driver;
	public FacebookLoginPage facebookLoginPage;
	public FacebookUserHomePage facebookUserHomePage;
	
	@BeforeClass
	public void initBrowserDriver() {
		driver = BrowserFactory.createFirefoxDriver();
		facebookLoginPage = new FacebookLoginPage(driver);
		facebookUserHomePage = new FacebookUserHomePage(driver);
	}
	
	@Test
	public void post() throws Exception {
		facebookLoginPage.loginToFacebook();
		Assert.assertTrue(facebookUserHomePage.isUserLoggedIn(), "USer not logged in, profile picture not displayed.");
		
		facebookUserHomePage.publishPost();
	}
	
	@AfterClass
	public void closeBrowserDriver() {
		try {
			//driver.quit();
		} catch(Exception exception) {
			
		}
	}
	
}
