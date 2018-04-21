package org.circles.automation.browserutils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

/**
 * @author arunkumar
 * 
 * The Class SeleniumAndroidUtil - contains basic reusable android application interaction components.
 */
public class SeleniumAndroidUtil {

	private static final Logger LOGGER = Logger.getLogger(SeleniumAndroidUtil.class);
	
	public AppiumDriver<MobileElement> driver;
	
	/**
	 * Instantiates a new selenium android util object.
	 *
	 * @param driver the driver
	 */
	public SeleniumAndroidUtil(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * Enter text into text field.
	 *
	 * @param locator the locator
	 * @param value the value
	 * @throws NoSuchElementException the no such element exception
	 */
	public void enterText(Locator locator, String value) throws NoSuchElementException {
		try {
			driver.findElement(locator.getBy()).sendKeys(value);
		} catch(NoSuchElementException noSuchElementException) {
			LOGGER.error("enterText - "+noSuchElementException.getMessage());
		}
	}
	
	/**
	 * Click on the element.
	 *
	 * @param locator the locator
	 * @throws Exception the exception
	 */
	public void click(Locator locator) throws Exception {
		driver.findElement(locator.getBy()).click();
	}
	
	
	/**
	 * Click on element if it is displayed.
	 *
	 * @param locator the locator
	 */
	public void clickIfDisplayed(Locator locator) {
		boolean isElementDisplayed = false;
		MobileElement element = null;
		try {
			element = (MobileElement) driver.findElement(locator.getBy());
			isElementDisplayed = element.isDisplayed();
		} catch(NoSuchElementException noSuchElementException) {
			isElementDisplayed = false;
		}
		if(isElementDisplayed) {
			element.click();
		}
	}
	
	/**
	 * Checks if is element displayed.
	 *
	 * @param locator the locator
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(Locator locator) {
		try {
			return driver.findElement(locator.getBy()).isDisplayed();
		} catch(Exception exception) {
			return false;
		}
	}

}
