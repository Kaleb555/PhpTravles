package com.phptravles.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/***
 * This is a common global selenium libraries and can be used for any selenium
 * projects
 * 
 * @author Frank created: 12/22/2018
 */
public class PhpTravelLibrary {
	private WebDriver driver;

	/***
	 * This is the Constructor
	 * 
	 * @param _driver
	 */
	public PhpTravelLibrary(WebDriver _driver) {
		driver = _driver;
	}

	/**
	 * This is the method enters text string to a edit WebElement in web-site
	 * 
	 * @param by
	 * @param value
	 */
	public void enterTextField(By by, String value) {
		try {
			WebElement textWebElement = driver.findElement(by);
			textWebElement.clear();
			textWebElement.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method starts Chrome browser and maximize it
	 * 
	 * @return WebDriver
	 */
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver74.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	/***
	 * This is a fluent wait, waits dynamically for a WebElement and polls the
	 * source html
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			@SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetElem;
	}

	public void selectDropDown(By by, String visibleTextValue) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByVisibleText(visibleTextValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDropDown(By by, int index) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDropDown(String attributeValue, By by) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByValue(attributeValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickButton(By by) {
		try {
			WebElement button = driver.findElement(by);
			button.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/***
	 * This method clicks or un-click any check-box and radio buttons
	 * @param by
	 * @param isUserWantsToCheckTheBox
	 */
	public void handleCheckBoxRadioBtn(By by, boolean isUserWantsToCheckTheBox) {
		WebElement elem = driver.findElement(by);
		boolean checkboxState = elem.isSelected();

		if (checkboxState == true) // by default checkbox is checked
		{
			if (isUserWantsToCheckTheBox == true) { // Scenario1
													// Do nothing
			} else {// Scenario2
				elem.click();
			}
		} else // by default checkbox is Not checked
		{
			if (isUserWantsToCheckTheBox == true) { // Scenario3
				elem.click();
			} else { // Scenario4
						// Do nothing
			}
		}

	}
	
	public void clickHiddenElement(By by){
		try{
			WebElement hiddenElem = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click();", hiddenElem);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void scrollToWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
