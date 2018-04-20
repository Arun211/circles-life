package com.circles.facebook.pages;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage {
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator emailAddress = new Locator("id", "email", "Email address field in login page");
	private Locator password = new Locator("id", "pass", "Password field in login page");
	private Locator loginButton = new Locator("xpath", "//label[@id='loginbutton']/input", "Login button in login page");

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(this.driver);
	}
	
	public void loginToFacebook() throws Exception {
		seleniumUtil.enterText(emailAddress, "taskscircles.life@gmail.com");
		seleniumUtil.enterText(password, "Seniorqa1");
		seleniumUtil.click(loginButton);
	}
}
