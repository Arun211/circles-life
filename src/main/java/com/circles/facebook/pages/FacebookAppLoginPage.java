package com.circles.facebook.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.circles.automation.browserutils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author arunkumar
 * 
 * FacebookAppLoginPage class - Page Object Model class for Facebook App login page.
 * 
 * Note - Description for locator object is given in Locator object initialization
 */
public class FacebookAppLoginPage {
	
	private AndroidDriver<MobileElement> driver;
	
	private Locator emailAddressField = new Locator("id", "email", "Email address field in login page");
	private Locator passwordField = new Locator("id", "pass", "Password field in login page");
	private Locator loginButton = new Locator("xpath", "//label[@id='loginbutton']/input", "Login button in login page");

	/**
	 * Instantiates a new Facebook app login page object.
	 *
	 * @param driver the driver
	 */
	public FacebookAppLoginPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * Logins to Facebook.
	 *
	 * @param email the email
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void loginToFacebook(String email, String password) throws Exception {
		try {
			WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@text='Email or Phone']"));
			System.out.println(emailField.getText());
			emailField.sendKeys("Test");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		try {
			WebElement button = driver.findElementByName("Email or Phone");
		    button.sendKeys("Test");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
