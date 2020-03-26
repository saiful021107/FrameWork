package com.qa.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.BaseClass;
import com.qa.Utility.Helper;




public class LoginToSauceTest extends BaseClass {
	LoginPage loginPage;
	
	@Test
	public void LoginApp() {
		
		logger=Reports.createTest("Login To Sauce");
		
		 loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting the Application");
		loginPage.LoginToSauce(Config.getDataFromConfig("UserName"), Config.getDataFromConfig("Password"));
		
		logger.pass("Login Success");
	}
	
	@Test(dependsOnMethods="LoginApp")
	public void verifyPurchaseTitleTest() {
		
		String title=driver.getTitle();
		System.out.println("Sauce demo title is: "+title);
		Assert.assertEquals(title,"Swag Labs");

		
	}
	
	@Test (dependsOnMethods="verifyPurchaseTitleTest")
	public void selectingRedTshirt() throws InterruptedException {
		Helper.highlightElement(driver,loginPage.OpenMenu,"Orange");
		Helper.highlightElement(driver,loginPage.cart,"Orange" );
		Helper.highlightElement(driver,loginPage.boltTshirt, "Orange");
		loginPage.boltTshirt.click();
		Helper.highlightElement(driver,loginPage.redTshirt, "Orange");
		loginPage.redTshirt.click();
		Helper.highlightElement(driver,loginPage.cart,"Orange" );
		Thread.sleep(10000);
		loginPage.cart.click();      
	}
		
		@Test(dependsOnMethods="selectingRedTshirt")
		public void CartTest() throws Exception {
		Helper.highlightElement(driver,loginPage.qtyText,"Orange");
		Helper.highlightElement(driver,loginPage.descriptionText,"Orange");
		Helper.highlightElement(driver,loginPage.sauceBTshirt,"Orange");
		Helper.highlightElement(driver,loginPage.RTshirt,"Orange");
		Helper.highlightElement(driver,loginPage.checkOutBtn,"Orange");
		loginPage.checkOutBtn.click();
		Thread.sleep(10000);
		}
		@Test (dependsOnMethods="CartTest")
		public void CheckOutTest() throws Exception {
		Helper.highlightElement(driver,loginPage.checkoutInfoText,"Orange");
		Helper.highlightElement(driver,loginPage.firstName,"Orange");
		Helper.highlightElement(driver,loginPage.lastName,"Orange");
		Helper.highlightElement(driver,loginPage.postalCode,"orange");
		loginPage.firstName.sendKeys(Config.getDataFromConfig("FirstName"));
		loginPage.lastName.sendKeys(Config.getDataFromConfig("LastName"));
		loginPage.postalCode.sendKeys(Config.getDataFromConfig("Zip"));
		loginPage.continueBtn.click();
		Thread.sleep(10000);
		}
		@Test (dependsOnMethods="CheckOutTest")
		public void endOfTest() throws Exception {
		Helper.highlightElement(driver,loginPage.checkOutOverViewText,"Orange");
		Helper.highlightElement(driver,loginPage.paymentInfoText,"Orange");
		Helper.highlightElement(driver,loginPage.deliveryName,"Orange");
		Helper.highlightElement(driver,loginPage.iteamTotal, "Orange");
		Helper.highlightElement(driver,loginPage.totalDollar, "Orange");
		Helper.highlightElement(driver,loginPage.finishBtn,"Orange");
		loginPage.ClickOnFinishBtn();
		Thread.sleep(10000);
	
		Helper.highlightElement(driver,loginPage.thankYouText,"Orange");
		}
	     }
	


