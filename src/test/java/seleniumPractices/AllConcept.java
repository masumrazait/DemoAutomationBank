package seleniumPractices;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The total no of link present on page: " + links.size());
		for (WebElement link : links) {
			String text = link.getText();
			String href = link.getAttribute("href");
			System.out.println("Test on the link: " + text);
			System.out.println("Href on the link: " + href);
		}
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./TestData/imagess.png"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.titleContains("jQuery contextMenu (2.x)"));
		driver.findElement(By.linkText("Left-Click Trigger")).click();
		WebElement left = driver.findElement(By.xpath("//span[text()='left click me']"));
		Actions action = new Actions(driver);
		action.doubleClick(left).perform();
		WebElement alertButton = driver.findElement(By.xpath("//span[text()='Quit']"));
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);

		System.out.println(driver.getTitle());
		driver.quit();
	}
}
