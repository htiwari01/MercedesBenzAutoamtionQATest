package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class PaymentTypeTest extends TestBase {
	
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	ShopBasketPage shopBasketPage;
	AddressAndDeliveryPage addressAndDeliveryPage;
	PaymentPage paymentPage;
	String sheetName = "contacts";
	
	//Current class constructor to call parent class constructor
	public PaymentTypeTest(){
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
	}
	
	@DataProvider
	public Object[][] getUserTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getUserTestData")
	public void selectPaymentTypeTest(String firstName, String lastName, String number, String street, String town, String postalCode, String emailId) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys("150 Sports Roadster, W30, 1935");
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList("150 Sports Roadster, W30, 1935");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
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
		Assert.assertTrue(paymentPage.creditCardPayment.isDisplayed());	
	}
	
	@Test(dataProvider="getUserTestData")
	public void selectCardTypeTest(String firstName, String lastName, String number, String street, String town, String postalCode, String emailId) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys("150 Sports Roadster, W30, 1935");
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList("150 Sports Roadster, W30, 1935");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
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
		Assert.assertTrue(paymentPage.visa.isDisplayed());	
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
