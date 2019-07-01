package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class VerificationAndOrderPlacementTest  extends TestBase{
	
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	ShopBasketPage shopBasketPage;
	AddressAndDeliveryPage addressAndDeliveryPage;
	PaymentPage paymentPage;
	VerificationAndOrderPlacementPage verificationAndOrderPlacementPage;
	String sheetName = "contacts";
	String searchItemName = "150 Sports Roadster, W30, 1935";
	
	//Current class constructor to call parent class constructor
	public VerificationAndOrderPlacementTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		productDescriptionPage = new ProductDescriptionPage();
		productCollectionPage = new ProductCollectionPage();
		shopBasketPage = new ShopBasketPage();
		addressAndDeliveryPage = new AddressAndDeliveryPage();
		paymentPage = new PaymentPage();
		verificationAndOrderPlacementPage = new VerificationAndOrderPlacementPage();
	}
	
	@DataProvider
	public Object[][] getUserTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getUserTestData")
	public void itemPriceTest(String firstName, String lastName, String number, String street, String town, String postalCode, String emailId) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(searchItemName);
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(searchItemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String pdpItemPrice = productDescriptionPage.itemPriceValue.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		Thread.sleep(3000);
		shopBasketPage.sbcontinueButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		addressAndDeliveryPage.placeOrderAsGuest(emailId);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		addressAndDeliveryPage.addressAndDeliveryDetails(firstName, lastName, number, street, town, postalCode);
		Thread.sleep(3000);
		addressAndDeliveryPage.continueToPaymentButton.click();
		Thread.sleep(15000);
		paymentPage.creditCardPayment.click();
		Thread.sleep(2000);
		paymentPage.visa.click();
		paymentPage.nextButton.click();	
		Assert.assertTrue(verificationAndOrderPlacementPage.itemPrice.getText().contains(pdpItemPrice));
	}
	
	@Test(dataProvider="getUserTestData")
	public void itemColorTest(String firstName, String lastName, String number, String street, String town, String postalCode, String emailId) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(searchItemName);
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(searchItemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String pdpItemColor = productDescriptionPage.itemColor.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		Thread.sleep(3000);
		shopBasketPage.sbcontinueButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		addressAndDeliveryPage.placeOrderAsGuest(emailId);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		addressAndDeliveryPage.addressAndDeliveryDetails(firstName, lastName, number, street, town, postalCode);
		Thread.sleep(3000);
		addressAndDeliveryPage.continueToPaymentButton.click();
		Thread.sleep(15000);
		paymentPage.creditCardPayment.click();
		Thread.sleep(2000);
		paymentPage.visa.click();
		paymentPage.nextButton.click();	
		Assert.assertTrue(verificationAndOrderPlacementPage.itemColor.getText().contains(pdpItemColor));
	}  
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
