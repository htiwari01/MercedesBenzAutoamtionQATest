package com.mercedeseonlineshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercedeseonlineshop.qa.base.TestBase;

public class PaymentPage extends TestBase {
	
	@FindBy(xpath = "//li[@data-testid='co-stepnavigation-3']")
	WebElement paymentType;
	
	@FindBy(xpath = "//label[@data-testid='dcp-co-payment-modes_options-CREDITCARD-label']//descendant::strong[@class='ng-binding']")
	WebElement creditCardPayment;
	
	@FindBy(xpath = "//label[@data-testid='dcp-co-payment-modes_options-visa-label']")
	WebElement visa;
	
	@FindBy(xpath = "//button[@data-testid='co-func-footer-forward']")
	WebElement nextButton;
	
	
	public PaymentPage(){
		PageFactory.initElements(driver, this);
	}

}
