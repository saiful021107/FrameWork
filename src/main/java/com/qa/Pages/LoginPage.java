package com.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//*[@id='user-name']")
	public WebElement username;
	
	@FindBy(xpath="//*[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	public WebElement logInBtn;
	
	// Purchase Page......................
	

	@FindBy(xpath="//*[contains(text(),'Open Menu')]")
	public WebElement OpenMenu;
	
	@FindBy(xpath="//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
	public WebElement cart;
	
	@FindBy(xpath="//*[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	public WebElement sauceBTshirt;
	
	@FindBy(xpath="(//*[@id=\"inventory_container\"]//div[3]/button)[3]")
	public WebElement boltTshirt;
	
	@FindBy(xpath="//*[contains(text(),'Test.allTheThings() T-Shirt (Red)')]")
	public WebElement RTshirt;
	
	@FindBy(xpath="(//*[@id=\"inventory_container\"]//div[3]/button)[6]")
	public WebElement redTshirt;
	
	@FindBy(xpath="//*[@class='cart_footer']/a[contains(@class,'btn_action checkout_button')]")
	public WebElement checkOutBtn;
	
	@FindBy(xpath="//*[contains(@class,'subheader')]")
	public WebElement checkOutOverView;
	
	@FindBy(xpath="//*[contains(text(),'QTY')]")
	public WebElement qtyText;
	
	@FindBy(xpath="//*[contains(text(),'DESCRIPTION')]")
	public WebElement descriptionText;
	
	@FindBy(xpath="//div[contains(text(),'Checkout: Your Information')]")
	public WebElement checkoutInfoText;
	
	
	
	@FindBy(xpath="//input[@id='first-name']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	public WebElement postalCode;
	
	@FindBy(xpath="	//input[@class='btn_primary cart_button' and @type='submit']")
	public WebElement continueBtn;
	
	//**************************//
	
	@FindBy(xpath="//div[@class='subheader']")
	public WebElement checkOutOverViewText;
	
	@FindBy(xpath="//*[contains(text(),'Payment Information:')]")
	public WebElement paymentInfoText;
	
	@FindBy(xpath="//div[contains(text(),'FREE PONY EXPRESS DELIVERY!')]")
	public WebElement deliveryName;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	public WebElement iteamTotal;
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	public WebElement totalDollar;
	
	@FindBy(xpath="//*[contains(@class,'btn_action cart_button')]")
	public WebElement finishBtn;
	
	//*************************//
	
	@FindBy(xpath="//div[@class='subheader']")
	public WebElement finishText;
	
	@FindBy(xpath="//*[contains(text(),'THANK YOU FOR YOUR ORDER')]")
	public WebElement thankYouText;
	
	
	
	
	
	
	// Actions:
	
	public void EnterCustInfo(String fName, String lname, String zip) {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lname);
		postalCode.sendKeys(zip);
		continueBtn.click();
		
	}
	
	public String verifyPurchasePageTitle() {
		return driver.getTitle();
				
	}
	public void ClickOnFinishBtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",finishBtn);
	}
	

	
	//Purchase Page........................
	
	public void LoginToSauce(String usernameApp, String passwordApp) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		username.sendKeys(usernameApp);
		password.sendKeys(passwordApp);
		logInBtn.click();
	}

}
