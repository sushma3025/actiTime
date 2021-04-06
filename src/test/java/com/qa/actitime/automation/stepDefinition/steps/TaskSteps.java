package com.qa.actitime.automation.stepDefinition.steps;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.actitime.automation.cucumber.TestContext;
import com.qa.actitime.automation.dataProvider.Log4jUtil;
import com.qa.actitime.automation.helpers.CommonUtilities;
import com.qa.actitime.automation.pageObjects.Task;
import com.qa.actitime.automation.runners.TestRunner;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskSteps {
	
	TestContext  testContext;
	Task task;
	WebDriver driver;
	static Logger log = Log4jUtil.loadLogger(TestRunner.class);

	public TaskSteps(TestContext context){
		this.testContext = context;
		task = testContext.getPageObjectManager().getTaskPage();
		driver = testContext.getWebDriverManager().getDriver();
		
	}
		
	
	@Given("^I click on tasks$")
	public void i_click_on_tasks() throws Throwable {
		task.createTask();
		log.info("Clicked on Create task");
		String fileName = CommonUtilities.getcurrentdatetime();
		CommonUtilities.takeSnapShot(driver, "C:/WorkSpaceNew/ActiTime/screenshots/" + fileName + ".jpg" );
	   
	}

	@Given("^I click on Add new Customer$")
	public void i_click_on_Add_new_Customer() throws Throwable {
	    task.addNew();
	    task.createCustomer();
		log.info("clicked on Create New Customer");

	}

	@When("^I enter the details$")
	public void i_enter_the_details(DataTable testData) throws Throwable {
		Map<String, String> data = testData.asMap(String.class, String.class);
		task.enterDetails(data.get("customerName"));
	}

	@Then("^I should see the task created$")
	public void i_should_see_the_task_created(DataTable testData) throws Throwable {
		Map<String, String> data = testData.asMap(String.class, String.class);
		task.verify(data.get("customerName"));
	}



}
