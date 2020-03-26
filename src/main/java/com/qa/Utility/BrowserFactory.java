package com.qa.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) {
		
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Saiful021107/Documents/FromYouTubeExperts"
					+ "/TestNG-Framework/TestAutomationFramework/Drivers/chromedriver");
			driver= new ChromeDriver();
		}else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/Users/Saiful021107/Documents/FromYouTubeExperts"
					+ "/TestNG-Framework/TestAutomationFramework/Drivers/geckodriver");
			driver= new FirefoxDriver();
		}else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/iedriver");
			driver= new InternetExplorerDriver();
		}else {
			System.out.println("We dont support this browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
