package com.trello.gmc.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserWorkspacePage {
	WebDriver driver;
	public TrelloUserWorkspacePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Create new board']")
	private WebElement createNewBoardOption;
	
	
	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}
	
	@FindBy(xpath="//input[@data-testid='create-board-title-input']")
	private WebElement createBoardTitleTextBox;
	
	
	public WebElement getCreateBoardTitleTextBox() {
		return createBoardTitleTextBox;
	}
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement CreateBoardHiddenPopupCreateButton;
	
	
	public WebElement getCreateBoardHiddenPopupCreateButton() {
		return CreateBoardHiddenPopupCreateButton;
	}
	
	@FindBy(xpath="//input[@value='Add card']/..//a")
	private WebElement cancleListEditingIcon;
	
	public WebElement getCancleListEditingIcon() {
		return cancleListEditingIcon;
	}
	
	@FindBy(xpath="//a[contains(@title,'currently active')]")
	private WebElement currentActiveBoardLink;
	
	public WebElement getCurrentActiveBoardLink() {
		return currentActiveBoardLink;
	}
	@FindBy(xpath="//a[contains(@title,'currently active')]/following-sibling::div//span[@data-testid='OverflowMenuHorizontalIcon']")
	private WebElement currentActiveBoardMenuHorizontalIcon;
	
	public WebElement getCurrentActiveBoardMenuHorizontalIcon() {
		return currentActiveBoardMenuHorizontalIcon;
	}
	
	@FindBy(xpath = "//span[text()='Close board']")
	private WebElement closeBoardButton;
	
	
	public WebElement getCloseBoardButton() {
		return closeBoardButton;
	}
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement closeBoardConfirmationButton;
	
	public WebElement getCloseBoardConfirmationButton() {
		return closeBoardConfirmationButton;
	}
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteBoardButton;
	
	public WebElement getPermanentlyDeleteBoardButton() {
		return permanentlyDeleteBoardButton;
	}
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteBoardButton;
	
	public WebElement getDeleteBoardButton() {
		return deleteBoardButton;
	}

	@FindBy(xpath = "//button[@data-testid='header-member-menu-button']")
	private WebElement profileIcon;

	public WebElement getProfileIcon() {
		return profileIcon;
	}
	
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logoutOption;
	public WebElement getLogoutOption() {
		return logoutOption;
	}
	
}