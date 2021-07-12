package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.login.pages.BrowserFactory;
import com.login.pages.LoginPageUsingPageFactory;

public class TestScriptUsingPageFactory {
	
	@Test
	public void loginApp() {
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");
		LoginPageUsingPageFactory page = new LoginPageUsingPageFactory(driver);
		page.loginToHRM("Admin", "admin123 ");
		driver.quit();
	}
}
