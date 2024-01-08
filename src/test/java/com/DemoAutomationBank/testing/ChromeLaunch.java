package com.DemoAutomationBank.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class ChromeLaunch {

	@Test
    public void myTestMethod() throws InterruptedException {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		
		String Title=driver.getTitle();
		System.out.println(Title);
		Thread.sleep(3000);
		driver.quit();
		

	}

}
