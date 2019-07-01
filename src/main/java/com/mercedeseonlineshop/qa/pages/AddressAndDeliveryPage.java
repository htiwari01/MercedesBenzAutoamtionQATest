package com.mercedeseonlineshop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercedeseonlineshop.qa.base.TestBase;

public class AddressAndDeliveryPage extends TestBase {
	
	@FindBy(xpath = "//li[@data-testid = 'co-stepnavigation-2']")
	WebElement AddressAndDelivery;
	
	@FindBy(xpath = "//input[@data-testid = 'co-order-process-login-guest-user-email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[@data-testid='co-order-process-login-guest-user-cta']")
	WebElement placeOrderAsGuest;
	
	@FindBy(xpath = "//label[@data-testid='dcp-schema-form-radios-inline_co_payment_address-salutationCode-radio-id-0-label']")
	WebElement salutation;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-line2']")
	WebElement number;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-line1']")
	WebElement street;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-town']")
	WebElement town;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-postalCode']")
	WebElement postalCode;
	
	@FindBy(xpath = "//button[@data-testid='co-func-footer-forward']")
	WebElement continueToPaymentButton;
	
	@FindBy(xpath = "//input[@data-testid='dcp-schema-form-default_co_payment_address-email']")
	WebElement emailBox;
	
	public AddressAndDeliveryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void placeOrderAsGuest(String emailId){
		emailAddress.sendKeys(emailId);
		placeOrderAsGuest.click();
	}
	
	public void addressAndDeliveryDetails(String fn, String ln, String num, String str, String tow, String pc){
		salutation.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		number.sendKeys(num);
		street.sendKeys(str);
		town.sendKeys(tow);
		postalCode.sendKeys(pc);
		//continueToPaymentButton.click();
		
	}

}
