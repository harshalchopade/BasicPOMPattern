package demo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class PDFReader {
	/*
	 * We are using org.apache.pdfbox library to read the pdf content.
	 * It works only for pdf files only which contains text only.
	 * If our pdf file contains the scanned copy of image then in that case it returns
	 * the null data.
	 * */
	@Test
	public void verifyLoginCredentials() throws InterruptedException, IOException {

		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//direct from website
		driver.get("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
		String currentUrl = driver.getCurrentUrl();

		//if file present in local machine
		//In this we dont need chrome driver and browser so comment that code.
		//pass the url directly in URL.
		driver.get("C:\\Users\\hchopade\\Downloads\\filename.pdf");
		
		//Code to read pdf 
		//FOR URL it work only if it having .pdf extension is present.
		URL url = new URL(currentUrl);
		InputStream stream = url.openStream();
		BufferedInputStream bis = new BufferedInputStream(stream);
		PDDocument doc = null;
		doc = doc.load(bis);
		String pdfContent = new PDFTextStripper().getText(doc);
		Assert.assertTrue(pdfContent.contains("dummy"));
		System.out.println(pdfContent);
	}
}
