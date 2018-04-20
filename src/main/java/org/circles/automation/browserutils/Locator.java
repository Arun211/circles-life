package org.circles.automation.browserutils;

import org.openqa.selenium.By;

public class Locator {
	
	private String locatorType;
	private String locatorValue;
	private String locatorDescription;
	
	public Locator(String locatorType, String locatorValue, String locatorDescription) {
		this.locatorType = locatorType;
		this.locatorValue = locatorValue;
		this.locatorDescription = locatorDescription;
	}
	
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
		default:
			return null;
		}
	}

	public String getLocatorType() {
		return locatorType;
	}

	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}

	public String getLocatorValue() {
		return locatorValue;
	}

	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}

	public String getLocatorDescription() {
		return locatorDescription;
	}

	public void setLocatorDescription(String locatorDescription) {
		this.locatorDescription = locatorDescription;
	}
	
}
