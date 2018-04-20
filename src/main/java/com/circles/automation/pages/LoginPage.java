package com.circles.automation.pages;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator signinBlock = new Locator("xpath", "//span[text()='SIGN IN']", "Signin block");
	private Locator emailAddress = new Locator("name", "email", "Email address field in signin page");
	private Locator password = new Locator("name", "password", "Password field in signin page");
	private Locator signinButton = new Locator("xpath", "//button[text()='Sign In']", "Signin button in Sign In page");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	public boolean verifyUserIsInSigninPage() {
		seleniumUtil.waitForElementToBeDisplayed(signinBlock, 10);
		try {
			return driver.findElement(signinBlock.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	public void loginToApplication() throws Exception {
		seleniumUtil.enterText(emailAddress, "taskscircles.life@gmail.com");
		seleniumUtil.enterText(password, "Seniorqa@");
		seleniumUtil.click(signinButton);
	}
	
	public boolean verifySigninSuccess() {
		seleniumUtil.waitForElementToDisappear(signinBlock, 10);
		try {
			return !driver.findElement(signinBlock.getBy()).isDisplayed();
		} catch(Exception exception) {
			return true;
		}
		
	}
}
