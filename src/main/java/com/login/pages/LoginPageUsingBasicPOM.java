package com.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Page Object Model
 * 
 * Page Object Model is just a design pattern not a framework.
 * As name says we will be  working as pages (page will be pure java classes)
 * Based on application behavior we will be creating a separate page and will store all the locator and respective
 * method to use them.
 * 
 * Advantage
 * Script will be more readable format.
 * Using POM you will be able to achieve below three features
 * Easy to maintain, readable format, reusable scripts.
 * 
 * 
 * */

public class LoginPageUsingBasicPOM {

	WebDriver driver;

	public LoginPageUsingBasicPOM(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginButton = By.id("btnLogin");

	public void enterUserName(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLoginButton() {

		driver.findElement(loginButton).click();
	}

	public void loginToHRM(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		clickOnLoginButton();
	}
}
