package com.qa.actitime.automation.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	String path = System.getProperty("user.dir")+"/src/test/resources/configs/TestConfiguration.properties";



	
	public ConfigFileReader() throws IOException
	{
        propertyFileReader(path);
		
	}
	
	public void propertyFileReader(String path) throws IOException
	{
		properties  = new Properties();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
	}
	
	
	public String getReportConfigPath(){

		String reportConfigPath = properties.getProperty("reportConfigPath");

		if(reportConfigPath!= null) return reportConfigPath;

		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");

	}
	
	public String getproperties(String key) throws IOException
	{
		
	    String value = properties.getProperty(key);
	    if(value != null) return value;
	    else throw new RuntimeException("Config Path not specified in the Configuration.properties file for the Key:"+key+"");
	    					
	    
	
	}

}
