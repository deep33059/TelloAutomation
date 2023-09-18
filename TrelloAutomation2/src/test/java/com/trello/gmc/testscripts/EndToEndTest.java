package com.trello.gmc.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.trello.gmc.genericutility.BaseClass;
import com.trello.gmc.pomrepo.TrelloHomePage;
import com.trello.gmc.pomrepo.TrelloLoginContinuePage;
import com.trello.gmc.pomrepo.TrelloLoginPage;
import com.trello.gmc.pomrepo.TrelloLogoutPage;
import com.trello.gmc.pomrepo.TrelloUserWorkspacePage;

public class EndToEndTest extends BaseClass {
	@Test
	// Loging and Logout E2E
	public void Trello_03() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String expectedHomePageTitle = excelUtils.readStringExcelData("Trello_03", 6, 5);
		wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		String actualHomePageTitle = driver.getTitle();
		assertEquals(actualHomePageTitle, expectedHomePageTitle);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		String expectedLoginPageTitle = excelUtils.readStringExcelData("Trello_03", 8, 5);
		wait.until(ExpectedConditions.titleIs(expectedLoginPageTitle));
		String actualLoginPageTitle = driver.getTitle();
		assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
		String expectedLoginPageUrl = excelUtils.readStringExcelData("Trello_03", 9, 5);
		wait.until(ExpectedConditions.urlToBe(expectedLoginPageUrl));
		String actualLoginPageUrl = driver.getCurrentUrl();
		assertEquals(actualLoginPageUrl, expectedLoginPageUrl);
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtils.readPropertyFileData("email"));
		loginPage.getContinueButton().click();
		TrelloLoginContinuePage loginContinuePage = new TrelloLoginContinuePage(driver);
		wait.until(ExpectedConditions.visibilityOf(loginContinuePage.getPasswordTextField())).sendKeys(fileUtils.readPropertyFileData("password"));
		loginContinuePage.getPasswordFluterIcon().click();
		loginContinuePage.getLoginButton().click();
		String expecterFractionUserWorkspaceUrl = excelUtils.readStringExcelData("Trello_03", 17, 5);
		wait.until(ExpectedConditions.urlContains(expecterFractionUserWorkspaceUrl));
		String expectedUserWorkspaceTitle = excelUtils.readStringExcelData("Trello_03", 18, 5);
		wait.until(ExpectedConditions.titleIs(expectedUserWorkspaceTitle));
		String actualUserWorkspaceTitle = driver.getTitle();
		assertEquals(actualUserWorkspaceTitle, expectedUserWorkspaceTitle);
		TrelloUserWorkspacePage userWorkspacePage = new TrelloUserWorkspacePage(driver);
		wait.until(ExpectedConditions.visibilityOf(userWorkspacePage.getProfileIcon())).click();
		userWorkspacePage.getLogoutOption().click();
		String expecterFractionLogoutPageUrl = excelUtils.readStringExcelData("Trello_03", 22, 5);
		wait.until(ExpectedConditions.urlContains(expecterFractionLogoutPageUrl));
		String expecterLogoutPageTitle = excelUtils.readStringExcelData("Trello_03", 23, 5);
		wait.until(ExpectedConditions.titleIs(expecterLogoutPageTitle));
		String actualLogoutPageTitle = driver.getTitle();
		assertEquals(expecterLogoutPageTitle, actualLogoutPageTitle);
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.getlogoutButton().click();
		expectedHomePageTitle = excelUtils.readStringExcelData("Trello_03", 25, 5);
		wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		actualHomePageTitle = driver.getTitle();
		assertEquals(actualHomePageTitle, expectedHomePageTitle);
		String expectedFractionHomePageTitle = excelUtils.readStringExcelData("Trello_03", 26, 5);
		wait.until(ExpectedConditions.urlContains(expectedFractionHomePageTitle));
	}
	@Test
	// Create Board and Delete Board
	public void Trello_04() throws IOException {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String expectedHomePageTitle = excelUtils.readStringExcelData("Trello_03", 6, 5);
		wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		String actualHomePageTitle = driver.getTitle();
		assertEquals(actualHomePageTitle, expectedHomePageTitle);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		String expectedLoginPageTitle = excelUtils.readStringExcelData("Trello_03", 8, 5);
		wait.until(ExpectedConditions.titleIs(expectedLoginPageTitle));
		String actualLoginPageTitle = driver.getTitle();
		assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
		String expectedLoginPageUrl = excelUtils.readStringExcelData("Trello_03", 9, 5);
		wait.until(ExpectedConditions.urlToBe(expectedLoginPageUrl));
		String actualLoginPageUrl = driver.getCurrentUrl();
		assertEquals(actualLoginPageUrl, expectedLoginPageUrl);
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtils.readPropertyFileData("email"));
		loginPage.getContinueButton().click();
		TrelloLoginContinuePage loginContinuePage = new TrelloLoginContinuePage(driver);
		// org.openqa.selenium.StaleElementReferenceException
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginContinuePage.getPasswordTextField())));
		wait.until(ExpectedConditions.visibilityOf(loginContinuePage.getPasswordTextField())).sendKeys(fileUtils.readPropertyFileData("password"));
		loginContinuePage.getPasswordFluterIcon().click();
		loginContinuePage.getLoginButton().click();
		String expecterFractionUserWorkspaceUrl = excelUtils.readStringExcelData("Trello_03", 17, 5);
		wait.until(ExpectedConditions.urlContains(expecterFractionUserWorkspaceUrl));
		String expectedUserWorkspaceTitle = excelUtils.readStringExcelData("Trello_03", 18, 5);
		wait.until(ExpectedConditions.titleIs(expectedUserWorkspaceTitle));
		String actualUserWorkspaceTitle = driver.getTitle();
		assertEquals(actualUserWorkspaceTitle, expectedUserWorkspaceTitle);
		TrelloUserWorkspacePage userWorkspacePage = new TrelloUserWorkspacePage(driver);
		userWorkspacePage.getCreateNewBoardOption().click();
		userWorkspacePage.getCreateBoardTitleTextBox().sendKeys(fileUtils.readPropertyFileData("boardTitle"));
		wait.until(ExpectedConditions.elementToBeClickable(userWorkspacePage.getCreateBoardHiddenPopupCreateButton())).click();
		wait.until(ExpectedConditions.visibilityOf(userWorkspacePage.getCancleListEditingIcon())).click();
		actions.moveToElement(userWorkspacePage.getCurrentActiveBoardLink()).perform();
		actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(userWorkspacePage.getCurrentActiveBoardMenuHorizontalIcon()))).click().perform();
		userWorkspacePage.getCloseBoardButton().click();
		userWorkspacePage.getCloseBoardConfirmationButton().click();
		userWorkspacePage.getPermanentlyDeleteBoardButton().click();
		userWorkspacePage.getDeleteBoardButton().click();
		wait.until(ExpectedConditions.visibilityOf(userWorkspacePage.getProfileIcon())).click();
		userWorkspacePage.getLogoutOption().click();
		String expecterFractionLogoutPageUrl = excelUtils.readStringExcelData("Trello_03", 22, 5);
		wait.until(ExpectedConditions.urlContains(expecterFractionLogoutPageUrl));
		String expecterLogoutPageTitle = excelUtils.readStringExcelData("Trello_03", 23, 5);
		wait.until(ExpectedConditions.titleIs(expecterLogoutPageTitle));
		String actualLogoutPageTitle = driver.getTitle();
		assertEquals(expecterLogoutPageTitle, actualLogoutPageTitle);
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.getlogoutButton().click();
		expectedHomePageTitle = excelUtils.readStringExcelData("Trello_03", 25, 5);
		wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		actualHomePageTitle = driver.getTitle();
		assertEquals(actualHomePageTitle, expectedHomePageTitle);
		String expectedFractionHomePageTitle = excelUtils.readStringExcelData("Trello_03", 26, 5);
		wait.until(ExpectedConditions.urlContains(expectedFractionHomePageTitle));
	}
}