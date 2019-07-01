package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class ShoppingCartTest extends TestBase {
	
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	ShopBasketPage shopBasketPage;
	String sheetName = "items";
	
	//Current class constructor to call parent class constructor
	public ShoppingCartTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		productDescriptionPage = new ProductDescriptionPage();
		productCollectionPage = new ProductCollectionPage();
		shopBasketPage = new ShopBasketPage();
	}
	
	@DataProvider
	public Object[][] getItemTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getItemTestData")
	public void itemNameTest(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		//productCollectionPage.expliciteWait();
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String itemDesc = productDescriptionPage.itemDescription.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(shopBasketPage.shoppingBasketText.isDisplayed());
		Assert.assertEquals(itemDesc, shopBasketPage.sbItemDescription.getText());
	}  
	
	@Test(dataProvider = "getItemTestData")
	public void itemColorTest(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		//productCollectionPage.expliciteWait();
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String itemColor = productDescriptionPage.itemColor.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(shopBasketPage.shoppingBasketText.isDisplayed());
		Assert.assertTrue(shopBasketPage.sbItemColor.getText().contains(itemColor));
		
	} 
	
	@Test(dataProvider = "getItemTestData")
	public void itemPriceTest(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		//productCollectionPage.expliciteWait();
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String itemPrice = productDescriptionPage.itemPriceValue.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(shopBasketPage.shoppingBasketText.isDisplayed());
		Assert.assertEquals(itemPrice, shopBasketPage.sbItemPrice.getText());
		
	}  
	
	@Test(dataProvider = "getItemTestData")
	public void totalPriceIncludingVAT(String itemName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productCollectionPage.searchItemButton.click();
		productCollectionPage.searchTerm.sendKeys(itemName);
		//productCollectionPage.expliciteWait();
		Thread.sleep(10000);
		productCollectionPage.selectItemFromList(itemName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		productDescriptionPage.addToCartButton.click();
		String itemPrice = productDescriptionPage.itemPriceValue.getText();
		productDescriptionPage.addToCartButton.click();
		productDescriptionPage.cartIcon.click();
		productDescriptionPage.gotoBasketButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(shopBasketPage.shoppingBasketText.isDisplayed());
		Assert.assertEquals(itemPrice, shopBasketPage.totalPrice.getText());
	} 
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
