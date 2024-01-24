package com.DemoAutomationBank.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		List<WebElement>link=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links present in page :"+link.size());
		for(WebElement links:link) {
			String Text=links.getText();
			String Href=links.getAttribute("href");
			System.out.println("Text is Present :"+Text);
			System.out.println("Link is Present :"+Href);
		}
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
