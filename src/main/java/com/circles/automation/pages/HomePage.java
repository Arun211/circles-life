package com.circles.automation.pages;

import org.circles.automation.browserutils.Locator;
import org.openqa.selenium.WebDriver;

/**
 * @author arunkumar
 * 
 * The Class HomePage - Page Object Model class for Circles.life home page
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class HomePage {
	
	private WebDriver driver;
	
	private Locator buyLink = new Locator("linktext", "Buy", "Login link");
	
	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Move to sign in page.
	 */
	public void moveToSignInPage() {
		driver.findElement(buyLink.getBy()).click();
	}
}
