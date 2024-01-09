package com.DemoAutomationBank.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoAutomationBank.pageObjects.CustomerLogin;

public class CustomerLogin_TestCase extends BaseClass {

	@Test(priority = 1)
	public void CustomerLoginValidDetailsTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		CustomerLogin lp = new CustomerLogin(driver);
		lp.clickOnCustomerLoginBtn();
		logger.info("User clicked on Login Button");
		Thread.sleep(2000);
				if (driver.getTitle().equals("XYZ Bank")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			captureScreen(driver, "CustomerLoginValidDetailsTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		Select FromCutomer = new Select(lp.selectCutomerName());
		FromCutomer.selectByIndex(8);
		logger.info("User choose to Cutomer Id");

		lp.clickOnLoginBtn();
		logger.info("User Clicked on Login button");
		Thread.sleep(3000);
		
		System.out.println(driver.getPageSource());
		
		Thread.sleep(3000);
		/*
		if (driver.getPageSource().contains("Bill Payment Complete")) {
			Assert.assertTrue(true);
			logger.info("Bill Payment is transfer from account was successful. test passed!");
		} else {
			captureScreen(driver, "BillPayWithValidDetailsTest");
			Assert.assertTrue(false);
			logger.info("Bill Payment is not transfer from account was successful. test failed");
		}*/

	}
}