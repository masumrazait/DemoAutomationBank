package com.DemoAutomationBank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class InsurancesRegister {
	@Test
	public void registerInsurance() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "https://demo.guru99.com/insurance/v1/register.php";
		driver.get(url);
		String CurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, CurrentUrl);
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.id("user_title"));
		Select select = new Select(title);
		select.selectByVisibleText("Mr");
		driver.findElement(By.xpath("//input[@id='user_firstname']")).sendKeys("Masum");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Raza");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8084555049");
		WebElement year = driver.findElement(By.xpath("//select[@name='year']"));
		WebElement month = driver.findElement(By.xpath("//select[@name='month']"));
		WebElement date = driver.findElement(By.xpath("//select[@name='date']"));
		Select years = new Select(year);
		Select months = new Select(month);
		Select days = new Select(date);
		years.selectByValue("1995");
		months.selectByIndex(9);
		days.selectByValue("6");
		driver.findElement(By.xpath("//input[@name='licencetype']")).click();
		WebElement licencePeriod = driver.findElement(By.xpath("//select[@name='licenceperiod']"));
		WebElement occupation = driver.findElement(By.xpath("//select[@name='occupation']"));

		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("./Drivers/masum.png"));
		
		Select lcPeriod = new Select(licencePeriod);
		Select occpations = new Select(occupation);
		lcPeriod.selectByValue("4");
		occpations.selectByVisibleText("Engineer");
		driver.findElement(By.xpath("//input[@name='street']")).sendKeys("Nobonagar");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='user_address_attributes_county']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@name='post_code']")).sendKeys("560076");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("masumraza@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Masum@1234567");
		driver.findElement(By.xpath("//input[@name='c_password']")).sendKeys("Masum@1234567");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		String loginUrl = "https://demo.guru99.com/insurance/v1/index.php";
		String currentLogin = driver.getCurrentUrl();
		if (loginUrl != currentLogin) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Fail");
		}
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("masumraza@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Masum@1234567");
		driver.findElement(By.xpath("//input[@name='submit'][@type='submit']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);

		WebElement emails = driver.findElement(By.xpath("//h4[text()='masumraza@gmail.com']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(driver.getTitle()));
		driver.quit();
	}
}
