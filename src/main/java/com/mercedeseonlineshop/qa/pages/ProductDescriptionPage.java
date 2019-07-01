package com.mercedeseonlineshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercedeseonlineshop.qa.base.TestBase;

public class ProductDescriptionPage extends TestBase {
	
	//Page factory
	@FindBy(css = ".dcp-pdp-buy-box-add-to-basket__cta--one-variant")
	WebElement addToCartButton;
	
	@FindBy(css = ".dcp-pdp-grid__buy-box .dcp-pdp-grid-buy-box__large .dcp-pdp-buy-box-add-to-basket__price span:nth-of-type(1)")
	WebElement itemPriceValue;
	
	@FindBy(xpath = "//h2[@data-testid='pdp-shortdescription-header__articlename']")
	WebElement itemDescription;
	
	@FindBy(css = ".pdp-buy-box-colors .ng-binding span:nth-of-type(1)")
	WebElement itemColor;
	
	
	@FindBy(xpath = "//div[@class='co-header-cart ng-scope']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//span[@class='co-header-cart-go-to-basket']")
	WebElement gotoBasketButton;
	
	@FindBy(xpath = "//span[@data-testid='pdp-shortdescription-articlenumber']")
	WebElement itemNUmber;
	
	@FindBy(xpath = "//button[@data-testid='pdp-buy-box-add-to-basket-got-to-cart']")
	WebElement goToShoppingBasketButton;
	
	
	//Initialize page factory
	public ProductDescriptionPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addItemToCart(){
		addToCartButton.click();	
	}
	
	public void goToShoppingBasket(){
		cartIcon.click();
		gotoBasketButton.click();
	}
	
}
