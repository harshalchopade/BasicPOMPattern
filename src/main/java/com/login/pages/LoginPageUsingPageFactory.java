package com.login.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/* Page Factory
 * Inorder to support the PageObject pattern , WebDriver support library contains a factory class.
 * We have seperate  method to initialize web element of page object using initElement
   (return the page object of the class we are passing.)
 * Imp feature of Page Factory is cache feature that will store all frequently used WebElement in cache.
 * 
 * */
public class LoginPageUsingPageFactory {
	WebDriver driver;

	public LoginPageUsingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@value='LOGIN']")
	@CacheLookup
	WebElement submit;

	public void loginToHRM(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();

	}
}
