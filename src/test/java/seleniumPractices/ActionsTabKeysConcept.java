package seleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsTabKeysConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickEle = driver.findElement(By.cssSelector("span.context-menu-one"));
		driver.quit();
	}

}
