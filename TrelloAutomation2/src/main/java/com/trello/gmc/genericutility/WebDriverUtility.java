package com.trello.gmc.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author CodeRoverAbhay
 */
public class WebDriverUtility {
	WebDriverWait wait;
	/**
	 * implicitWait method is used for wait till the find element identify the WebElement 
	 * @param driver
	 * @exception NoSuchElementException
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void explicitWait (WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
}