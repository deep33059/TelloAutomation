package com.trello.gmc.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;

	public TrelloLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user")
	private WebElement emailTextField;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	@FindBy(id = "login")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}
		
	@FindBy(id="login-submit")
	private WebElement loginButton;
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(linkText = "Sign up for an account")
	private WebElement signupLink;

	public WebElement getSignupLink() {
		return signupLink;
	}
}