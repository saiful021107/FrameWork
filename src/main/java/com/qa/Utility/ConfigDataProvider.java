package com.qa.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	
	
	Properties prop;
	
	public ConfigDataProvider() {
		 
		File src= new File("/Users/Saiful021107/Documents/FromYouTubeExperts/TestNG-Framework"
				+ "/TestAutomationFramework/Configuration/Config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load the Properties File."+e.getMessage());
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getURL() {
		return prop.getProperty("qaURL");
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}

}
