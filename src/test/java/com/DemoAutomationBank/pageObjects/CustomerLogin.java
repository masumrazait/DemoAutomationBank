package com.DemoAutomationBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLogin {
	WebDriver ldriver;

	public CustomerLogin(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//button[text()='Customer Login']")
	@CacheLookup
	WebElement CustomerLoginBtn;

	@FindBy(id = "userSelect")
	@CacheLookup
	WebElement selectCutomer;

	@FindBy(xpath = "//button[text()='Login']")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath = "//button[text()='Home']")
	@CacheLookup
	WebElement HomeBtn;

	// Action Method
	public void clickOnCustomerLoginBtn() {
		CustomerLoginBtn.click();
	}

	public WebElement selectCutomerName() {
		selectCutomer.click();
		return selectCutomer;
	}

	public void clickOnLoginBtn() {
		LoginBtn.click();
	}
	
	public void clickOnHomeBtn() {
		HomeBtn.click();
	}
}
