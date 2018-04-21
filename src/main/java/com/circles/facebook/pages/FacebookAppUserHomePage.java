package com.circles.facebook.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.circles.automation.browserutils.Locator;
import org.circles.automation.browserutils.SeleniumAndroidUtil;

/**
 * @author arunkumar
 * 
 * The Class FacebookAppUserHomePage - Page Object Model class for Facebook App user home page after successful login.
 * 
 * Note - Comments for locator object is given in Locator object initialization
 */
public class FacebookAppUserHomePage {
	
	private AppiumDriver<MobileElement> driver;
	private SeleniumAndroidUtil seleniumAndroidUtil;
	
	private Locator writePostSection = new Locator("xpath", "//android.view.ViewGroup[contains(@content-desc,'Write something here...')]", "Write post section");
	private Locator postText = new Locator("xpath","//android.view.ViewGroup[contains(@content-desc,'${MESSAGE}')]", "Post text");
	
	/**
	 * Instantiates a new facebook app user home page object.
	 *
	 * @param driver the driver
	 */
	public FacebookAppUserHomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		seleniumAndroidUtil = new SeleniumAndroidUtil(driver);
	}
	
	/**
	 * Checks whether the user is logged in.
	 *
	 * @return true, if user is logged in
	 */
	public boolean isUserLoggedIn() {
		return seleniumAndroidUtil.isElementDisplayed(writePostSection);
	}
	
	/**
	 * Publish post in facebook wall.
	 *
	 * @param messageToPost - the message to post
	 * @throws Exception the exception
	 */
	public boolean verifyPost(String messageToVerify) throws Exception {
		Locator locator = postText.replace("${MESSAGE}", messageToVerify);
		return seleniumAndroidUtil.isElementDisplayed(locator);
	}
}
