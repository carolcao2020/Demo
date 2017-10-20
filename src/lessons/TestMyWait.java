package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import library.MyWait;

public class TestMyWait {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.icloud.com");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.switchTo().frame("auth-frame");
		MyWait.isElementPresent(driver, ".//*[@id='appleId']", 10).sendKeys("abc");
		MyWait.isElementPresent(driver, ".//*[@id='pwd']", 10).sendKeys("123");
		driver.quit();
	}
}
