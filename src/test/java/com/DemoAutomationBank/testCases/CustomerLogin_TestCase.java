package com.DemoAutomationBank.testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoAutomationBank.pageObjects.CustomerLogin;

public class CustomerLogin_TestCase extends BaseClass {

	@Test (invocationCount = 155)
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
		FromCutomer.selectByIndex(5);
		logger.info("User choose to Cutomer Id");

		lp.clickOnLoginBtn();
		logger.info("User Clicked on Login button");
		Thread.sleep(3000);

		
		if (driver.getPageSource().contains("Neville Longbottom")) {
			Assert.assertTrue(true);
			logger.info("Account login successful. test passed!");
		} else {
			captureScreen(driver, "CustomerLoginValidDetailsTest");
			Assert.assertTrue(false);
			logger.info("Account login was successful. test failed");
		}
		lp.clickOnHomeBtn();
		logger.info("User Clicked on Home button");

	}
}