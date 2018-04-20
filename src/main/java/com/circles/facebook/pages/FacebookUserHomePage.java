package com.circles.facebook.pages;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FacebookUserHomePage {
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator profilePicture = new Locator("xpath", "//img[contains(@id,'profile_pic_header')]", "Profile picture in user home page");
	
	private Locator composePostLabel = new Locator("xpath","//span[contains(text(),'Compose Post')]", "Compose post text");
	private Locator postTextArea = new Locator("xpath","//div[@data-testid='status-attachment-mentions-input']//div[contains(@class,'_1mf')]/span", "Post text");
	private Locator postButton = new Locator("xpath", "//button/span[text()='Post']", "Post button");
	
	public FacebookUserHomePage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	public boolean isUserLoggedIn() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(profilePicture, 15);
			return driver.findElement(profilePicture.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	public void publishPost() throws Exception {
		seleniumUtil.click(composePostLabel);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(postTextArea.getBy());
		Actions action = new Actions(driver);
		action.sendKeys(ele, "First Test Post").build().perform();
		seleniumUtil.click(postButton);
	}
}
