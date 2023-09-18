package com.trello.gmc.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginContinuePage {
	WebDriver driver;

	public TrelloLoginContinuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "password")
	private WebElement passwordTextField;

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	@FindBy(xpath = "//div[contains(@class,'password')]//span")
	private WebElement passwordFluterIcon;
	
	public WebElement getPasswordFluterIcon() {
		return passwordFluterIcon;
	}

	@FindBy(id = "login-submit")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

}