package julyTestingPractice;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllSeleniumJavaConceptForQA {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 59);
		driver.get("https://interviewlikeapro.blogspot.com/2024/06/QA-Tester.html");
		System.out.println(driver.getTitle());

		String username = "admin";
		String password = "admin";
		String url = ("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
		driver.get(url);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement btn = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(btn).build().perform();
		driver.findElement(By.xpath("//span[text()='Quit']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./screenshot/imagesss.png"));
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(2000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links are present in page: " + links.size());
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			String text = link.getText();
			System.out.println("Href present in the page : " + href);
			System.out.println("Text present in the page : " + text);
		}
		Thread.sleep(3000);
		driver.get("https://www.wikipedia.org/");
		WebElement country = driver.findElement(By.id("searchLanguage"));
		Select dropdown = new Select(country);
		List<WebElement> options = dropdown.getOptions();
		// Loop through the options and print their text
		for (WebElement option : options) {
			System.out.println("All country list: " + option.getText());
		}
		dropdown.selectByVisibleText("Polski");
		dropdown.selectByIndex(11);
		dropdown.selectByValue("cs");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//strong[text()='Deutsch']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Jacoby Jones']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		driver.get("https://www.wikipedia.org/");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[text()='Search']")).click();
		Thread.sleep(3000);
		driver.quit();

	}
}
