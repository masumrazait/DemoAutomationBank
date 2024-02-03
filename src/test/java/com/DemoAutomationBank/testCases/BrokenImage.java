package com.DemoAutomationBank.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "https://demo.guru99.com/insurance/v1/register.php";
		
		List<WebElement>img=driver.findElements(By.tagName("img"));
		for(WebElement imgs:img) {
			if(imgs.getAttribute("naturalWidth").equals("0")) {
				System.out.println("image is broken");
			}else {
				System.out.println("image is not broken:");
			}
		}
		driver.quit();
	}

}
