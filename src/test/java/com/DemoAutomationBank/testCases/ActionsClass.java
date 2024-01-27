package com.DemoAutomationBank.testCases;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		
		WebElement src=driver.findElement(By.id("drag1"));
		WebElement trg=driver.findElement(By.id("div2"));
		Actions action=new Actions(driver);
		action.dragAndDrop(src, trg).build().perform();
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("./Screenshots/img.png"));
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='country']"));
		
		Select select=new Select(dropdown);
		select.selectByIndex(5);
		Thread.sleep(4000);
		
		driver.quit();
	}
}
