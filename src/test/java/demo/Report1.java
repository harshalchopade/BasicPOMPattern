package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Report1 {

	@Test
	public  void testReport() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://wanikirtesh.github.io/report.html?fltlist=department,region,&department=Marketing&region=UAE&");
		Thread.sleep(3000);
		List<WebElement> values = driver.findElements(By.xpath("//tr/td[7]//input"));
		// List<WebElement> values = driver.findElements(By.xpath("//tr//td[7]"));
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(values.size(), 9, "Available Records should be 9");

		// System.out.println(values.size());
		int k = 0;
		for (WebElement value : values) {
			if (value.isSelected()) {
				k++;
			}
		}
		// System.out.println(k);
		softAssertion.assertEquals(k, 4, "There should be 4 selected check box");
		softAssertion.assertAll();

		List<WebElement> records = driver.findElements(By.xpath("//tr[4]//td[(text())]"));
		List<String> actuallist = new ArrayList<String>();
		
		WebElement checkboxstatus = driver.findElement(By.xpath("//tr[4]//td//input"));
		System.out.println("value is " + String.valueOf(checkboxstatus.isSelected()));

		for (int i = 0; i <= records.size(); i++) {
			if (i == 6) {
				actuallist.add((String.valueOf(checkboxstatus.isSelected())));
			} else
				actuallist.add(records.get(i).getText());
		}
		//System.out.println(actuallist);
		ArrayList<String> Expectedlist = new ArrayList<String>();
		Expectedlist.add("4");
		Expectedlist.add("Chetan Patel");
		Expectedlist.add("Marketing");
		Expectedlist.add("UAE");
		Expectedlist.add("band 2");
		Expectedlist.add("5");
		Expectedlist.add("true");

		Assert.assertEquals(Expectedlist, actuallist);

		driver.quit();
	}
}
