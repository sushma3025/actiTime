package com.qa.actitime.automation.dataProvider;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jUtil {
	
	static Logger log;
	static String path = System.getProperty("user.dir")+"/src/test/resources/configs/log4j2.properties";
	public static final String filepath = FilenameUtils.separatorsToSystem(path);
	
	static {
		PropertyConfigurator.configure(filepath);
	}

	public static Logger loadLogger(Class<?> className) {
		
		
		log= LogManager.getLogger(className.getName());
		return log;
		
	}
	

}
