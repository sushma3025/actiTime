package com.qa.actitime.automation.cucumber;

import com.qa.actitime.automation.managers.PageObjectManager;
import com.qa.actitime.automation.managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
   

    public TestContext() {
    webDriverManager = new WebDriverManager();
	pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	
    }

    public PageObjectManager getPageObjectManager() {
	return pageObjectManager;
    }

    public WebDriverManager getWebDriverManager()
    {
    	return webDriverManager;
    }

}
