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

import com.DemoAutomationBank.pageObjects.BillPayPage;
import com.parabank.pageObjects.LoginPage;

public class PB_Bill_Pay_TestCase extends BaseClass {

	@Test(priority = 1)
	public void BillPayWithValidDetailsTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		BillPayPage bP = new BillPayPage(driver);

		lp.setUsername(readconfig.getUsernameID());
		logger.info("User entered the User Name:");

		lp.setPassword(readconfig.getUserPasswordId());
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();

		logger.info("User clicked on Login Button");
		Thread.sleep(2000);

		if (driver.getTitle().equals("ParaBank | Accounts Overview")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			captureScreen(driver, "BillPayWithoutAmountTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

		bP.clickOnBillPayMenu();
		logger.info("user clicked on Bill Payament Menu! ");
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("ParaBank | Bill Pay"));

		bP.setPayeeName(readconfig.getPayeeName());
		logger.info("User entered the name.");
		bP.setPayeeAddress(readconfig.getPayeeAddress());
		logger.info("User entered the Address.");
		bP.setPayeeCity(readconfig.getPayeeCity());
		logger.info("User entered the City.");
		bP.setPayeeState(readconfig.getPayeeState());
		logger.info("User entered the State.");
		bP.setPayeezipCode(readconfig.getPayeezipCode());
		logger.info("User entered the zipCode.");
		Thread.sleep(3000);
		bP.setPayeePhone(readconfig.getPayeePhone());
		logger.info("User entered the Phone Number.");
		bP.setPayeeAccountNumber(readconfig.getPayeeAccountNumber());
		logger.info("User entered the AccountNumber.");
		bP.setVerifyAccount(readconfig.getVerifyAccount());
		logger.info("User Verified the Account.");
		Thread.sleep(3000);
		Select FromAccount = new Select(bP.selectFromAccount());
		FromAccount.selectByIndex(0);
		logger.info("User choose to account from #");

		bP.clickOnSendPaymentSubmitBtn();
		logger.info("User Send Payment!");
		Thread.sleep(3000);

		if (driver.getPageSource().contains("Bill Payment Complete")) {
			Assert.assertTrue(true);
			logger.info("Bill Payment is transfer from account was successful. test passed!");
		} else {
			captureScreen(driver, "BillPayWithValidDetailsTest");
			Assert.assertTrue(false);
			logger.info("Bill Payment is not transfer from account was successful. test failed");
		}

	}

	@Test(priority = 2)
	public void BillPayWithoutAmountTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		BillPayPage bP = new BillPayPage(driver);

		bP.clickOnBillPayMenu();
		logger.info("user clicked on Bill Payament Menu! ");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("ParaBank | Bill Pay"));

		bP.clickOnSendPaymentSubmitBtn();
		logger.info("User Send Payment!");
		Thread.sleep(3000);

		boolean isAllInputsRequired = true;
		List<String> requiredFields = new ArrayList<String>();
		requiredFields.add("Payee name is required.");
		requiredFields.add("Address is required.");
		requiredFields.add("City is required.");
		requiredFields.add("State is required.");
		requiredFields.add("Zip Code is required.");
		requiredFields.add("Phone number is required.");
		requiredFields.add("Account number is required.");
		requiredFields.add("Account number is required.");
		requiredFields.add("The amount cannot be empty.");

		for (String requiredField : requiredFields) {
			if (!driver.getPageSource().contains(requiredField)) {
				isAllInputsRequired = false;
				break;
			}
		}

		if (isAllInputsRequired) {
			Assert.assertTrue(true);
			logger.info("Payment is not sent Complete! test passed");
		} else {
			captureScreen(driver, "BillPayWithoutAmountTest");
			Assert.assertTrue(false);
			logger.info("Payment is sent Complete! test failed");
		}

	}
}
