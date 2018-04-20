package com.circles.automation.pages;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;

public class UserHomePage {
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator myaccountLink = new Locator("xpath", "//a[@class='Links']//div[text()='MY ACCOUNT']", "My account link");
	private Locator emailField = new Locator("xpath", "//label[text()='Email']//following-sibling::div//input", "User email in account page");
	
	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	public boolean verifyUserHomePageDisplayed() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(myaccountLink, 15);
			return driver.findElement(myaccountLink.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	public void navigateToMyAccount() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(myaccountLink, 15);
			seleniumUtil.click(myaccountLink);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public String getEmail() {
		seleniumUtil.waitForElementToBeDisplayed(emailField, 15);
		return driver.findElement(emailField.getBy()).getAttribute("value");
	}
}
