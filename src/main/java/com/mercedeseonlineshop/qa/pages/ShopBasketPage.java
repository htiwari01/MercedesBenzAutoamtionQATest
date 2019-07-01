package com.mercedeseonlineshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercedeseonlineshop.qa.base.TestBase;

public class ShopBasketPage extends TestBase {
	
	@FindBy(xpath = "//span[@data-testid='co-orderline-list-product-name']")
	WebElement sbItemDescription;
	
	@FindBy(xpath = "//span[@data-testid='co-orderline-product-color']")
	WebElement sbItemColor;
	
	@FindBy(xpath = "//span[@data-testid='co-orderline-baseprice-value']")
	WebElement sbItemPrice;
	
	@FindBy(xpath = "//a[@data-testid='dcp-co-stepnavigation_cart']//descendant::span[@class='co-stepnavigation-step-label ng-binding']")
	WebElement shoppingBasketText;
	
	@FindBy(xpath = "//span[@data-testid='dcp-co-totals-total']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//button[@data-testid='co-func-footer-forward']")
	WebElement sbcontinueButton;
	
	@FindBy(xpath = "//img[@data-testid='co-orderline-product-image']")
	WebElement productImage;
	
	public ShopBasketPage(){
		PageFactory.initElements(driver, this);
	}

}


