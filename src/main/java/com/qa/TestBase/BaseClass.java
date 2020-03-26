package com.qa.TestBase;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Utility.BrowserFactory;
import com.qa.Utility.ConfigDataProvider;
import com.qa.Utility.ExcelDataProvider;
import com.qa.Utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider Excel;
	public ConfigDataProvider Config;
	public ExtentReports Reports;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite() 
	{
		Excel= new ExcelDataProvider();
		Config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Sauce_"+Helper.getCurrentDateTime()+".html"));
		Reports= new ExtentReports();
		Reports.attachReporter(extent);
	}
	
	
	@BeforeClass
	public void setUp() 
	{
		driver=BrowserFactory.startApplication(driver,Config.getBrowser(), Config.getURL());
	}
	
	
	
	@AfterClass
	public void tearDown() 
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception 
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		Reports.flush();
	}
	

}
