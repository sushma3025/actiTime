package com.qa.actitime.automation.stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.actitime.automation.cucumber.TestContext;
import com.qa.actitime.automation.managers.FileReaderManager;
import com.qa.actitime.automation.pageObjects.Login;
import com.qa.actitime.automation.pageObjects.Task;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BackgroundSteps {
	
	TestContext  testContext;
	Login login;
	WebDriver driver;
	
	public BackgroundSteps(TestContext context){
		this.testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		login = testContext.getPageObjectManager().getLoginPage();
		
	}
		
	
	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getproperties("url"));
	   
	}

	@When("^I enter Username and Password$")
	public void i_enter_Username_and_Password(DataTable testData) throws Throwable {
		Map<String, String> data = testData.asMap(String.class, String.class);

	    login.login(data.get("userName"), data.get("password"));
	    
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		login.click();
	    
	}

}
