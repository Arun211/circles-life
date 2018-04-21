package org.circles.automation.browserutils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * @author arunkumar
 * 
 * The Class Locator - Abstracts locator type, value and description.
 *  
 */
public class Locator {
	private static final Logger LOGGER = Logger.getLogger(Locator.class);
	
	/** The locator type like xpath, css selector, id, name, class name, link text, partial link text, tag name */
	private String locatorType;
	
	/** The locator value. Depends on locator type */
	private String locatorValue;
	
	/** The locator description. A short explanation to understand a locator */
	private String locatorDescription;
	
	/**
	 * Instantiates a new locator.
	 *
	 * @param locatorType the locator type
	 * @param locatorValue the locator value
	 * @param locatorDescription the locator description
	 */
	public Locator(String locatorType, String locatorValue, String locatorDescription) {
		this.locatorType = locatorType;
		this.locatorValue = locatorValue;
		this.locatorDescription = locatorDescription;
	}
	
	/**
	 * Creates and returns By object.
	 *
	 * @return the by object
	 */
	public By getBy() {
		switch(locatorType.toLowerCase()) {
		case "xpath":
			return By.xpath(locatorValue);
		case "cssselector":
			return By.cssSelector(locatorValue);
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "classname":
			return By.className(locatorValue);
		case "linktext":
			return By.linkText(locatorValue);
		case "partiallinktext":
			return By.partialLinkText(locatorValue);
		case "tagname":
			return By.tagName(locatorValue);
		default:
			LOGGER.fatal("Locator type given does not have support - "+locatorType);
			return null;
		}
	}
	
	public Locator replace(String key, String value) {
		System.out.println("Before - "+locatorValue);
		locatorValue.replaceAll(key, value);
		System.out.println("After - "+locatorValue);
		return this;
	}

	/**
	 * Gets the locator type.
	 *
	 * @return the locator type
	 */
	public String getLocatorType() {
		return locatorType;
	}

	/**
	 * Sets the locator type.
	 *
	 * @param locatorType the new locator type
	 */
	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}

	/**
	 * Gets the locator value.
	 *
	 * @return the locator value
	 */
	public String getLocatorValue() {
		return locatorValue;
	}

	/**
	 * Sets the locator value.
	 *
	 * @param locatorValue the new locator value
	 */
	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}

	/**
	 * Gets the locator description.
	 *
	 * @return the locator description
	 */
	public String getLocatorDescription() {
		return locatorDescription;
	}

	/**
	 * Sets the locator description.
	 *
	 * @param locatorDescription the new locator description
	 */
	public void setLocatorDescription(String locatorDescription) {
		this.locatorDescription = locatorDescription;
	}
	
}
