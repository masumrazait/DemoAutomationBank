package com.DemoAutomationBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {
	WebDriver ldriver;

	public BillPayPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Bill Pay']")
	@CacheLookup
	WebElement BillPayMenu;

	@FindBy(xpath ="//input[@name='payee.name']")
	@CacheLookup
	WebElement txtPayeeName;
	
	@FindBy(xpath ="//input[@name='payee.address.street']")
	@CacheLookup
	WebElement txtPayeeAddress;
	
	@FindBy(xpath ="//input[@name='payee.address.city']")
	@CacheLookup
	WebElement txtPayeeCity;
	
	@FindBy(xpath ="//input[@name='payee.address.state']")
	@CacheLookup
	WebElement txtPayeeState;
	
	@FindBy(xpath ="//input[@name='payee.address.zipCode']")
	@CacheLookup
	WebElement txtPayeezipCode;
	
	@FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")
	@CacheLookup
	WebElement txtPayeePhone;
	
	@FindBy(xpath ="//input[@name='payee.accountNumber']")
	@CacheLookup
	WebElement txtPayeeAccountNumber;

	@FindBy(xpath="//input[@name='verifyAccount']")
	@CacheLookup
	WebElement txtVerifyAccount;

	@FindBy(xpath="//input[@name='amount']")
	@CacheLookup
	WebElement txtBillPayAmount;

	@FindBy(xpath = "//select[@name='fromAccountId']")
	@CacheLookup
	WebElement SelectFromAccnt;
	
	@FindBy(xpath = "//input[@value='Send Payment']")
	@CacheLookup
	WebElement SendPaymentSubmitBtn;
	

	// Action Method
	public void clickOnBillPayMenu() {
		BillPayMenu.click();
	}

	public void setPayeeName(String PayeeName) {
		txtPayeeName.sendKeys(PayeeName);
	}

	public void setPayeeAddress(String PayeeAddress) {
		txtPayeeAddress.sendKeys(PayeeAddress);
	}
	
	public void setPayeeCity(String PayeeCity) {
		txtPayeeCity.sendKeys(PayeeCity);
	}
	
	public void setPayeeState(String PayeeState) {
		txtPayeeState.sendKeys(PayeeState);
	}
	
	public void setPayeezipCode(String PayeezipCode) {
		txtPayeezipCode.sendKeys(PayeezipCode);
	}
	
	public void setPayeePhone(String PayeePhone) {
		txtPayeePhone.sendKeys(PayeePhone);
	}
	
	public void setPayeeAccountNumber(String PayeeAccountNumber) {
		txtPayeeAccountNumber.sendKeys(PayeeAccountNumber);
	}
	
	public void setVerifyAccount(String VerifyAccount) {
		txtVerifyAccount.sendKeys(VerifyAccount);
	}
	
	public void setBillPayAmount(String Amount) {
		txtBillPayAmount.sendKeys(Amount);
	}
	
	public WebElement selectFromAccount() {
		SelectFromAccnt.click();
		return SelectFromAccnt;
	}
	
	public void clickOnSendPaymentSubmitBtn() {
		SendPaymentSubmitBtn.click();
	}

}
