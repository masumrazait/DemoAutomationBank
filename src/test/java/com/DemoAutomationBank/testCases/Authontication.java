package com.DemoAutomationBank.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authontication {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String user = "admin";
		String pswd = "admin";
		String url = "https://" + user + ":" + pswd + "@" + "the-internet.herokuapp.com/basic_auth";

		driver.get(url);
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
