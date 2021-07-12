package demo;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.deque.axe.AXE;
import com.login.pages.LoginPageUsingBasicPOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class AccessibilityTesting {
	/* To do accessibility testing/ ally testing we need to use library provided by
	 * deque labs (https://github.com/dequelabs/axe-selenium-java)
	 * Go to src/test/resource/axe.min.js file we need to put in our project under
	 * src/main/resources folder.
	 * Also add axe-selenium dependency in pom.xml
	 * 
	 * */

	@Test
	public void verifyLoginCredentials() throws InterruptedException
	{
		final URL scriptURL = AccessibilityTesting.class.getResource("/axe.min.js");
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://gps.scramtest.com");
		
		//To find overall violation present on the page
		JSONObject responseJSON = new AXE.Builder(driver, scriptURL).analyze(); 
		JSONArray violations = responseJSON.getJSONArray("violations");
		
		if(violations.length()==0)
		{
			System.out.println("no errors");
		}
		else
		{
			AXE.writeResults("verifyLoginCredentials", violations);
			Assert.assertTrue(false, AXE.report(violations));
		}
		
		driver.quit();
		
	}
	
	@Test
	public void testSpecificSelectors() throws InterruptedException
	{
		final URL scriptURL = AccessibilityTesting.class.getResource("/axe.min.js");
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://gps.scramtest.com");
		
		//To find overall violation present on the page
		JSONObject responseJSON = new AXE.Builder(driver, scriptURL).include("title").analyze(); 
		JSONArray violations = responseJSON.getJSONArray("violations");
		
		if(violations.length()==0)
		{
			System.out.println("no errors");
		}
		else
		{
			AXE.writeResults("verifyLoginCredentials", violations);
			Assert.assertTrue(false, AXE.report(violations));
		}
		
		driver.quit();
		
	}
	
	@Test
	public void testAccessibilityWithWebelement() throws InterruptedException
	{
		final URL scriptURL = AccessibilityTesting.class.getResource("/axe.min.js");
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://gps.scramtest.com");
		
		//To find overall violation present on the page
		JSONObject responseJSON = new AXE.Builder(driver, scriptURL).analyze(driver.findElement(By.id(""))); 
		JSONArray violations = responseJSON.getJSONArray("violations");
		
		if(violations.length()==0)
		{
			System.out.println("no errors");
		}
		else
		{
			AXE.writeResults("verifyLoginCredentials", violations);
			Assert.assertTrue(false, AXE.report(violations));
		}
		
		driver.quit();
		
	}
}
