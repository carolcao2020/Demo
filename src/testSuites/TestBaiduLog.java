package testSuites;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaiduLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("baidu");
		PropertyConfigurator.configure(".\\Tools\\Log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.info("Start browser");
		
		driver.manage().window().maximize();
		logger.info("Maximize the window");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Wait 10 seconds");
		
		driver.get("http://www.baidu.com");
		logger.info("Open Baidu index page");
		
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		logger.info("Input some value");
		
		driver.quit();
		logger.info("Close and quit the browser");

	}

}