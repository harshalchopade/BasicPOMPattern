package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.login.pages.LoginPageUsingBasicPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class TestScriptUsingBasicPOM {
	
	@Test
	public void verifyLoginCredentials() throws InterruptedException
	{
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		LoginPageUsingBasicPOM login = new LoginPageUsingBasicPOM(driver);
		
		login.loginToHRM("Admin", "admin123");
		
		driver.quit();
		
	}
}
