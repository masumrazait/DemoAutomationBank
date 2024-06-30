package com.DemoAutomationBank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
		
		//screenshot concept
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./photo/img.png"));

		//scroll down concept
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");

		//screenshot concept
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("./photo/img1.png"));

		Thread.sleep(5000);

		//double click
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightclick = driver.findElement(By.xpath("//span[text()='right click me']"));
		action.contextClick(rightclick).build().perform();
		driver.findElement(By.xpath("//span[text()='Edit']")).click();

		//Alert concept
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());

		Thread.sleep(5000);
		alert.accept();
		WebElement submenus = driver.findElement(By.xpath("//a[text()='Submenus']"));
		submenus.click();
		Thread.sleep(5000);

		WebElement rt = driver.findElement(By.xpath("//span[text()='right click me']"));
		action.contextClick(rt).build().perform();
		WebElement parentmenu = driver.findElement(By.xpath("//span[text()='Sub group']"));

		//mouse over
		action.moveToElement(parentmenu).build().perform();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//span[text()='echo']")).click();
		
		//Authentication
		String username = "admin";
		String pswd = "admin";
		String Url = "https://" + username + ":" + pswd + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(Url);
		System.out.println(driver.getTitle());

		driver.get("https://www.wikipedia.org/");
		
		//drop down
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		Thread.sleep(3000);
		select.selectByValue("vi");
		Thread.sleep(3000);
		select.selectByVisibleText("Italiano");

		driver.quit();

	}

}
