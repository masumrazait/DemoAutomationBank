package seleniumPractices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassiCRMWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("masumit1526");
		driver.findElement(By.name("password")).sendKeys("Masumit1526@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='New Event']"));
		driver.findElement(By.xpath("//a[text()='New Event']")).click();
		WebDriverWait element=new WebDriverWait(driver, 30);
		element.until(ExpectedConditions.titleContains("CRMPRO"));
		driver.findElement(By.id("title")).sendKeys("New Meeting with raza");
		driver.findElement(By.id("f_trigger_c_start")).click();
		driver.findElement(By.xpath("//td[@class='day selected today']")).click();

		Thread.sleep(5000);

		driver.findElement(By.linkText("CONTACTS")).click();
		driver.quit();

	}

}
