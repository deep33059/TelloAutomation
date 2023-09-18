package com.trello.gmc.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	public JavaUtility javaUtils = new JavaUtility();
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtils = new ExcelUtility();

	@BeforeClass
	public void executeBeforeClass() throws IOException {
		String browser = fileUtils.readPropertyFileData("browser");
		if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		webDriverUtils.implicitWait(driver);
		driver.get(fileUtils.readPropertyFileData("url"));
	}

	@AfterClass
	public void executeAfterClass() {
		driver.manage().deleteAllCookies();
		driver.manage().window().minimize();
		driver.quit();
	}
}