package com.DemoAutomationBank.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/minitv");
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("Total Links on Page :" + link.size());
		for (WebElement links : link) {
			String Text = links.getText();
			String href = links.getAttribute("href");
			Thread.sleep(5000);
			System.out.println("Text on the Link : " + Text);
			System.out.println("Link on the Page : " + href);
		}

		java.util.List<WebElement> images = driver.findElements(By.tagName("img"));
		// Check each image for being broken
		for (WebElement image : images) {
			if (isImageBroken(image)) {
				System.out.println("Broken Image: " + image.getAttribute("src"));
			}
		}

		System.out.println(driver.getTitle());
		driver.quit();
	}

	private static boolean isImageBroken(WebElement image) {
		try {
			// Use the naturalWidth property to check if the image is broken
			return image.getAttribute("naturalWidth").equals("0");
		} catch (Exception e) {
			// Exception handling, e.g., if the attribute is not supported
			return false;
		}
	}
}