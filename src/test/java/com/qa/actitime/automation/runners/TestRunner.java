package com.qa.actitime.automation.runners;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import com.cucumber.listener.Reporter;
import com.qa.actitime.automation.dataProvider.Log4jUtil;
import com.qa.actitime.automation.managers.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/actitime.feature", glue = {
		"com.qa.actitime.automation.stepDefinition" }, monochrome = true, plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

	static Logger log = Log4jUtil.loadLogger(TestRunner.class);

	@AfterClass
	public static void writeExtentReport() throws IOException {
		String path = FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath();
		Reporter.loadXMLConfig(new File(path));

	}

	@AfterTest
	public void success() {
		log.info("Success");
	}
	
	

}
