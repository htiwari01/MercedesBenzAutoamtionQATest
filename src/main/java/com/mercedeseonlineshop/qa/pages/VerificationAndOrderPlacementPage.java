package com.mercedeseonlineshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercedeseonlineshop.qa.base.TestBase;

public class VerificationAndOrderPlacementPage extends TestBase {
	
	@FindBy(xpath = "//span[@data-testid='co-orderline-total-price']")
	WebElement itemPrice;
	
	@FindBy(xpath = "//span[@data-testid='co-orderline-product-color']")
	WebElement itemColor;
	
	
	public VerificationAndOrderPlacementPage(){
		PageFactory.initElements(driver, this);
	}

}
