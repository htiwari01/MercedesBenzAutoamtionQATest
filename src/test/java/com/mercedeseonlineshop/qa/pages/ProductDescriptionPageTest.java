package com.mercedeseonlineshop.qa.pages;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class ProductDescriptionPageTest extends TestBase{
	ProductDescriptionPage productDescriptionPage;
	ProductCollectionPage productCollectionPage;
	String sheetName = "items";
	
	//Current class constructor to call parent class constructor
	public ProductDescriptionPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		productDescriptionPage = new ProductDescriptionPage();
		productCollectionPage = new ProductCollectionPage();
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
		Assert.assertTrue(productDescriptionPage.itemDescription.isDisplayed());
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
		Assert.assertTrue(productDescriptionPage.itemColor.isDisplayed());
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
		Assert.assertTrue(productDescriptionPage.itemPriceValue.isDisplayed());
	}   
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
