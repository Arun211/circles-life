package com.circles.facebook.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.circles.automation.browserutils.Locator;

/**
 * @author arunkumar
 * 
 * The Class FacebookAppUserHomePage - Page Object Model class for Facebook App user home page after successful login.
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class FacebookAppUserHomePage {
	
	private AndroidDriver<MobileElement> driver;
	
	private Locator profilePicture = new Locator("xpath", "//img[contains(@id,'profile_pic_header')]", "Profile picture in user home page");
	private Locator composePostLabel = new Locator("xpath","//span[contains(text(),'Compose Post')]", "Compose post text");
	private Locator postTextArea = new Locator("xpath","//div[@data-testid='status-attachment-mentions-input']//div[contains(@class,'_1mf')]/span", "Post text");
	private Locator postButton = new Locator("xpath", "//button/span[text()='Post']", "Post button");
	
	/**
	 * Instantiates a new facebook app user home page object.
	 *
	 * @param driver the driver
	 */
	public FacebookAppUserHomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * Checks whether the user is logged in.
	 *
	 * @return true, if user is logged in
	 */
	public boolean isUserLoggedIn() {
		try {
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
	public boolean verifyPost(String messageToVerify) throws Exception {
		
		return false;
	}
}
