package com.phptravles.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PhpBasePage {
	public static WebDriver driver;
	public static PhpTravelLibrary myLibrary;
	
	@BeforeClass
	public void beforeAllTestStart(){
		myLibrary = new PhpTravelLibrary(driver);
	}
	
	@AfterClass
	public void afterAllTestCompleted(){
		
	}
	
	@BeforeMethod
	public void beforeEachTestStart() {
		driver = myLibrary.startChromeBrowser();	
	}

	@AfterMethod
	public void afterEachTestEnd() {
		try {
			Thread.sleep(10 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
