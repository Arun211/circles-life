package org.circles.automation.browserutils;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	public WebDriver driver;
	
	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean waitForElementToBeDisplayed(Locator locator, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
			return true;
		} catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean waitForElementToBeClickable(Locator locator, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		try {
			//wait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
			return true;
		} catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean waitForElementToDisappear(Locator locator, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator.getBy()));
			return true;
		} catch(Exception exception) {
			return false;
		}
	}
	
	public void enterText(Locator locator, String value) throws NoSuchElementException {
		try {
		driver.findElement(locator.getBy()).sendKeys(value);
		} catch(NoSuchElementException noSuchElementException) {
			noSuchElementException.printStackTrace();
		}
	}
	
	public void click(Locator locator) throws Exception {
		driver.findElement(locator.getBy()).click();
	}
}
