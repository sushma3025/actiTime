package com.qa.actitime.automation.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.automation.dataProvider.Log4jUtil;
import com.qa.actitime.automation.helpers.CommonUtilities;

import junit.framework.Assert;

public class Task {
	
	private WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	static Logger log = Log4jUtil.loadLogger(Task.class);

	
	
	public Task(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="container_tasks")
	private WebElement tasks;
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addNew;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newCustomer;
	
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement customerNameTextfield;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createCustomer;
	
	
	public void createTask() throws InterruptedException
	{
		tasks.click();
	}
	public void addNew()
	{
		addNew.click();
	}
	public void createCustomer()
	{
		newCustomer.click();
	}
	
	public void enterDetails(String customerName) throws InterruptedException
	{
		commonUtilities.enterText(driver, customerNameTextfield, customerName);
		Thread.sleep(3000);
		createCustomer.click();
		
	}
	
	public void verify(String customerName)
	{
		WebElement customerCreated = driver.findElement(By.xpath("//div[@title='" + customerName + "']"));
		String actual = customerCreated.getText().toString();
		String expected = customerName;
		Assert.assertEquals(expected, actual);
		driver.close();
		
		
	}
	

}
