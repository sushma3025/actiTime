package com.qa.actitime.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.automation.cucumber.TestContext;
import com.qa.actitime.automation.helpers.CommonUtilities;
import com.qa.actitime.automation.managers.PageObjectManager;

public class Login {
	
	private WebDriver driver;
	
	
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	
	@FindBy(id="username")
	private WebElement usernameTextField ;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepmeLoggedinCheckbox;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	private WebElement forgotPassword;
	
	
	public void login(String userName, String password)
	{

		CommonUtilities.enterText(driver, usernameTextField, userName);
		CommonUtilities.enterText(driver, passwordTextField, password);
		//usernameTextField.sendKeys("admin");
		//passwordTextField.sendKeys("manager");
		keepmeLoggedinCheckbox.click();
	
		
	}
	
	public void click()
	{
		loginButton.click();

	}
	
	public void ForgotPassword()
	{
		forgotPassword.click();
	}

}
