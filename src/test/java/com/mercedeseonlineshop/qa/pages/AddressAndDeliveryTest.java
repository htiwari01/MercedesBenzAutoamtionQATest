package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class AddressAndDeliveryTest extends TestBase {
	
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	ShopBasketPage shopBasketPage;
	AddressAndDeliveryPage addressAndDeliveryPage;
	String sheetName = "items";
	
	//Current class constructor to call parent class constructor
	public AddressAndDeliveryTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		productDescriptionPage = new ProductDescriptionPage();
		productCollectionPage = new ProductCollectionPage();
		shopBasketPage = new ShopBasketPage();
		addressAndDeliveryPage = new AddressAndDeliveryPage();
	}
	
	@DataProvider
	public Object[][] getItemTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getItemTestData")
	public void pageTitleTest(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		shopBasketPage.sbcontinueButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(addressAndDeliveryPage.AddressAndDelivery.isDisplayed()); 
	} 
	
	@Test(dataProvider = "getItemTestData")
	public void emailAddressTest(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		//productCollectionPage.expliciteWait();
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		//String itemDesc = productDescriptionPage.itemDescription.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		shopBasketPage.sbcontinueButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(addressAndDeliveryPage.emailBox.getText().contains("demo@gmail.com"));
	}  
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
