package org.sample.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sample.automation.browserutils.Locator;
import org.sample.automation.browserutils.SeleniumUtil;

/**
 * @author arunkumar
 * 
 * The Class FacebookUserHomePage - Page Object Model class for Facebook user home page after successful login.
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class FacebookUserHomePage {
	
	private WebDriver driver;
	private SeleniumUtil seleniumUtil;
	
	private Locator profilePicture = new Locator("xpath", "//img[contains(@id,'profile_pic_header')]", "Profile picture in user home page");
	private Locator composePostLabel = new Locator("xpath","//span[contains(text(),'Compose Post')]", "Compose post text");
	private Locator postTextArea = new Locator("xpath","//div[@data-testid='status-attachment-mentions-input']//div[contains(@class,'_1mf')]/span", "Post text");
	private Locator postButton = new Locator("xpath", "//button/span[text()='Post']", "Post button");
	
	/**
	 * Instantiates a new facebook user home page.
	 *
	 * @param driver the driver
	 */
	public FacebookUserHomePage(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 * Checks whether the user is logged in.
	 *
	 * @return true, if user is logged in
	 */
	public boolean isUserLoggedIn() {
		try {
			seleniumUtil.waitForElementToBeDisplayed(profilePicture, 15);
			return driver.findElement(profilePicture.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}
	
	/**
	 * Publish post in facebook wall.
	 *
	 * @param messageToPost - the message to post
	 * @throws Exception the exception
	 */
	public void publishPost(String messageToPost) throws Exception {
		seleniumUtil.click(composePostLabel);
		
		seleniumUtil.waitForElementToBeClickable(postButton, 5);
		WebElement ele = driver.findElement(postTextArea.getBy());
		
		Actions action = new Actions(driver);
		action.sendKeys(ele, messageToPost).build().perform();
		
		seleniumUtil.click(postButton);
	}
}
