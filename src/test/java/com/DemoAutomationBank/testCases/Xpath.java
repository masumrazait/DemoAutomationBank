package com.DemoAutomationBank.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/register.php");		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Masum Raza");
		driver.findElement(By.xpath("//table[@cellpadding='2']//tr[3]/td[2]/input")).sendKeys("Delhi");
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S1544269295%3A1706098416755040&theme=glif");
		driver.findElement(By.xpath("//input[@type='email'][@name='identifier']")).sendKeys("masumrazait@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
