package com.DemoAutomationBank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumAllBasicSyntax {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links present on page: " + links.size());
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			String text = link.getText();
			System.out.println("Href on the Page : " + href);
			System.out.println("Text on the Page : " + text);
		}

		// For dragAndDrop Functionality by Action Class

		WebElement src = driver.findElement(By.id("drag1"));
		WebElement target = driver.findElement(By.id("div2"));

		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).build().perform();

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./photo/img.png"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");

		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("./photo/img1.png"));

		Thread.sleep(5000);

		driver.quit();
	}

}
