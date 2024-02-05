package seleniumPractices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");// Page

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		element.click();
		Alert alerts = driver.switchTo().alert();
		System.out.println(alert.getText());
		alerts.accept();
		Thread.sleep(3000);
		
		element.click();
		Alert a = driver.switchTo().alert();
		System.out.println(alert.getText());
		a.dismiss();
		Thread.sleep(3000);
		
		WebElement Prompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		Prompt.click();
		Alert p = driver.switchTo().alert();
		System.out.println(alert.getText());
		p.sendKeys("masum raza");
		Thread.sleep(5000);
		p.accept();

		Thread.sleep(3000);
		driver.quit();
	}
}
