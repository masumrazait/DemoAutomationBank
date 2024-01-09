package com.DemoAutomationBank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// For Browser
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	// For Register Page
	public String clickOnRegister() {
		return pro.getProperty("registrLink");
	}
	
	public String getCustomerFirstName() {
		String CustomerFirstName = pro.getProperty("CustomerFirstName");
		return CustomerFirstName;
	}

	public String getCustomerLastName() {
		String CustomerLastName = pro.getProperty("CustomerLastName");
		return CustomerLastName;
	}

	public String getCustomerAddress() {
		String CustomerAddress = pro.getProperty("CustomerAddress");
		return CustomerAddress;
	}
	
	public String getCustomerCity() {
		String CustomerCity = pro.getProperty("CustomerCity");
		return CustomerCity;
	}
	
	public String getCustomerState() {
		String CustomerState = pro.getProperty("CustomerState");
		return CustomerState;
	}
	
	public String getCustomerZipCode() {
		String CustomerZipCode = pro.getProperty("CustomerZipCode");
		return CustomerZipCode;
	}
	
	public String getCustomerPhoneNumber() {
		String CustomerPhoneNumber = pro.getProperty("CustomerPhoneNumber");
		return CustomerPhoneNumber;
	}
	
	public String getCustomerSsn() {
		String CustomerSsn = pro.getProperty("CustomerSsn");
		return CustomerSsn;
	}
	
	public String getCustomerUsername() {
		String CustomerUsername = pro.getProperty("CustomerUsername");
		return CustomerUsername;
	}
	
	public String getCustomerPassword() {
		String CustomerPassword = pro.getProperty("CustomerPassword");
		return CustomerPassword;
	}
	
	public String getCustomerRepeatedPassword() {
		String CustomerRepeatedPassword = pro.getProperty("CustomerRepeatedPassword");
		return CustomerRepeatedPassword;
	}
	
	//For Login 
	public String getUsernameID() {
		String UsernameID = pro.getProperty("UsernameID");
		return UsernameID;
	}
	
	public String getUserPasswordId() {
		String UserPasswordId = pro.getProperty("UserPasswordId");
		return UserPasswordId;
	}
	
	public String getDesboardTitle() {
		return pro.getProperty("DesboardTitle");
	}
	
	public String getInvalidUser() {
		String InvalidUser = pro.getProperty("InvalidUser");
		return InvalidUser;
	}
	
	public String getWrongPassword() {
		String WrongPassword = pro.getProperty("WrongPassword");
		return WrongPassword;
	}
	
	//Transfer Funds
	public String getAmount() {
		String Amount = pro.getProperty("Amount");
		return Amount;
	}
	
	//Bill Payment
	public String getPayeeName() {
		String PayeeName = pro.getProperty("PayeeName");
		return PayeeName;
	}

	public String getPayeeAddress() {
		String PayeeAddress = pro.getProperty("PayeeAddress");
		return PayeeAddress;
	}

	public String getPayeeCity() {
		String PayeeCity = pro.getProperty("PayeeCity");
		return PayeeCity;
	}
	
	public String getPayeeState() {
		String PayeeState = pro.getProperty("PayeeState");
		return PayeeState;
	}
	
	public String getPayeezipCode() {
		String PayeezipCode = pro.getProperty("PayeezipCode");
		return PayeezipCode;
	}
	
	public String getPayeePhone() {
		String PayeePhone = pro.getProperty("PayeePhone");
		return PayeePhone;
	}
	
	public String getPayeeAccountNumber() {
		String PayeeAccountNumber = pro.getProperty("PayeeAccountNumber");
		return PayeeAccountNumber;
	}
	
	public String getVerifyAccount() {
		String VerifyAccount = pro.getProperty("VerifyAccount");
		return VerifyAccount;
	}
	
	public String getBillPayAmount() {
		String BillPayAmount = pro.getProperty("Amount");
		return BillPayAmount;
	}
	
}
