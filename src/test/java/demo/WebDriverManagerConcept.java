package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	WebDriver driver;
	//WebdriverManager is library which will help us to get the rid off from setting up the path
	//It is developed by bonigarcia.
	//We must have respective browser installed. ow will get cannot find binary chrome binary/opera binary etc
	//other methods are also availability like back compatibility.

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void geTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
