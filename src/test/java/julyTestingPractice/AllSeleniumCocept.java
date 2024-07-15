package julyTestingPractice;

import java.awt.Window;
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

public class AllSeleniumCocept {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Authentication
		String user = "admin";
		String pswd = "admin";
		String url = ("https://" + user + ":" + pswd + "@" + "the-internet.herokuapp.com/basic_auth");
		driver.get(url);

		// Actions
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).build().perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Edit']")).click();

		// Alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();

		// Links
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("total link is present in webpage : " + link.size());
		for (WebElement links : link) {
			String href = links.getAttribute("href");
			String text = links.getText();
			System.out.println("Links are : " + href);
			System.out.println("Text are : " + text);
		}
		Thread.sleep(3000);
		// Screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./Screenshot/imge.png"));
		Thread.sleep(2000);

		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");

		WebElement src = driver.findElement(By.id("drag1"));
		WebElement trg = driver.findElement(By.id("div2"));
		action.dragAndDrop(src, trg).build().perform();

		File srcs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcs, new File("./Screenshot/imge1.png"));
		Thread.sleep(-2000);

		// JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);

		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		js.executeScript("document.getElementById('tnb-google-search-input').value='masum'");
		Thread.sleep(3000);
		driver.get("https://www.wikipedia.org/");

		// drop down
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
