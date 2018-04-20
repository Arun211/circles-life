package com.circles.automation.pages;

import org.circles.automation.browserutils.Locator;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	
	private Locator buyLink = new Locator("linktext", "Buy", "Login link");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void moveToSignInPage() {
		driver.findElement(buyLink.getBy()).click();
	}
}
