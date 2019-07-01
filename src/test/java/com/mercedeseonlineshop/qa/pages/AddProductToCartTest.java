package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercedeseonlineshop.qa.base.TestBase;

public class AddProductToCartTest extends TestBase {
	
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	ShopBasketPage shopBasketPage;
	AddressAndDeliveryPage addressAndDeliveryPage;
	PaymentPage paymentPage;
	String sheetName = "contacts";
	
	//Current class constructor to call parent class constructor
	public AddProductToCartTest(){
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
	
	@Test
	public void itemNameTest(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys("150 Sports Roadster, W30, 1935");
		productCollectionPage.expliciteWait();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		productCollectionPage.selectItemFromList("150 Sports Roadster, W30, 1935");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		Assert.assertTrue(productDescriptionPage.itemDescription.isDisplayed());
	}
	
	@Test
	public void itemColorTest(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys("150 Sports Roadster, W30, 1935");
		productCollectionPage.expliciteWait();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		productCollectionPage.selectItemFromList("150 Sports Roadster, W30, 1935");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		Assert.assertTrue(productDescriptionPage.itemColor.isDisplayed());
	}
	
	@Test
	public void itemPriceTest(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys("150 Sports Roadster, W30, 1935");
		productCollectionPage.expliciteWait();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		productCollectionPage.selectItemFromList("150 Sports Roadster, W30, 1935");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		Assert.assertTrue(productDescriptionPage.itemPriceValue.isDisplayed());
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
