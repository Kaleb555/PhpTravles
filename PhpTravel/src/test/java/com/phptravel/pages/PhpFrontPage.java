package com.phptravel.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phptravles.library.PhpBasePage;

public class PhpFrontPage extends PhpBasePage {

	ReadPhpProperties ReadPhpProp = new ReadPhpProperties("ObjectMapFile/ObjectMap.properties");

	public PhpFrontPage PhpTravelLogin() {

		driver.get("http://phptravels.com/demo/");
	//driver.get("http://phptravels.com/demo/");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return this;

	}

	public PhpFrontPage PhpHotel() {
		/*WebElement menuList = driver.findElement(By.id("main-menu"));
		List<WebElement> menu = menuList.findElements(By.tagName("span"));
		menu.get(5).click();
		driver.findElement(By.partialLinkText("Flights Module")).click();
		driver.findElement(By.cssSelector("body > div.container.text-center > div > div > a.btn.btn-hero.btn-light-blue")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block")).click();*/
		driver.findElement(By.cssSelector("#body-section > section > div.cell > div > div > div.col-md-12 > ul > li.text-center.active")).click();
		return this;
	
	}

	public PhpFrontPage phpclick() {
	//	driver.findElement(by)
		
		return this;
	}
	
}
