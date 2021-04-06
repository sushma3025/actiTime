package com.qa.actitime.automation.managers;

import java.io.IOException;

import com.qa.actitime.automation.dataProvider.ConfigFileReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigFileReader() throws IOException {

		return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	}

}
