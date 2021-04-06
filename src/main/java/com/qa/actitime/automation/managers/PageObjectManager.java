package com.qa.actitime.automation.managers;

import org.openqa.selenium.WebDriver;

import com.qa.actitime.automation.helpers.CommonUtilities;
import com.qa.actitime.automation.pageObjects.Login;
import com.qa.actitime.automation.pageObjects.Task;

public class PageObjectManager {
	private WebDriver driver;
	private CommonUtilities commonUtilities;
	private Login login;
	private Task task;

	
	

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

}
	
	public Login getLoginPage()
    {
    	return (login ==null) ? login = new Login(driver):login;
    }
	
	
	public Task getTaskPage()
    {
    	return (task ==null) ? task = new Task(driver):task;
    }
    
	public CommonUtilities getCommonUtilities()
    {
		return (commonUtilities == null) ? commonUtilities = new CommonUtilities(): commonUtilities;
    	
    }
    
    
	
	
}
