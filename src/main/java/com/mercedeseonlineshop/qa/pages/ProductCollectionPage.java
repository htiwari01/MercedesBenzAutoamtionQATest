package com.mercedeseonlineshop.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedeseonlineshop.qa.base.TestBase;
import com.mercedeseonlineshop.qa.util.TestUtil;

public class ProductCollectionPage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath = "//span[text()='Product description ']")
	WebElement pdpTitle;
	
	@FindBy(css = ".utils-product-cms-carousel-container .col-xs-6:nth-of-type(1) .utils-product-cms-carousel-title")
	WebElement itemName;
	
	@FindBy(css = ".utils-product-cms-carousel-container .col-xs-6:nth-of-type(1) .utils-product-cms-carousel-price span")
	WebElement itemPrice;
	
	@FindBy(css = ".utils-product-cms-carousel-container .col-xs-6:nth-of-type(1)")
	WebElement item;
	
	@FindBy(xpath = "//ul[@class = 'dropdown-menu ng-isolate-scope']//li//descendant::a[@class = 'ng-scope ng-binding']")
	List<WebElement> itemList;
	
	@FindBy(xpath = "//a[contains(text(), 'Collection & accessories')]")
	WebElement collectionAndAccessories;
	
	@FindBy(css = ".header-search-open-trigger-label")
	WebElement searchItemButton;
	
	@FindBy(xpath = "//input[@id = 'searchTerm']")
	WebElement searchTerm;
	
	@FindBy(xpath = "//li[@ng-repeat = 'match in matches track by $index']//a")
	WebElement listSearchItem;
	
	@FindBy(xpath = "//a[@id='button-text']")
	WebElement cookiesButton;
	
	//Web Element initialization
	public ProductCollectionPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Select item from list items
	public void selectItemFromList(String itemName){
		for(int i=0; i<itemList.size(); i++){
			if(itemList.get(i).getText().contains(itemName)){
				itemList.get(i).click();
				break;
			}
		}
	}
	//Explicite wait for search result to display
	public void expliciteWait(){
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.pageLoadTimeOut);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']")));
	}
	
	
}
