package com.DemoAutomationBank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.DemoAutomationBank.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public static WebDriver driver;
	public static Logger logger;
	public boolean acceptNextAlert = true;
	  
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//log 
		logger=Logger.getLogger("ParaBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","D:\\My_Project\\Testing_Project\\DemoAutomationBank\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		/*
		 * if (br.equals("chrome")) { WebDriverManager.chromedriver().setup(); driver =
		 * new ChromeDriver(); }
		 */
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getIEPath());
			driver=new EdgeDriver();
		}
		
		
		driver.get(baseURL);

		// To maximize browser  
        driver.manage().window().maximize(); 
        
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        WebDriverWait wait = new WebDriverWait(driver,10);
       
}
        
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	


  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
}

}
