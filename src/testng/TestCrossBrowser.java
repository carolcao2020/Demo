package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCrossBrowser {
	@Test
	
	@Parameters("Browser")
	public void startBrowser(String browser){
//		System.setProperties("webdriver.gecko.driver",".\\Tools\\geckodriver.exe",);
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://www.baidu.com");
			driver.quit();
		}
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.baidu.com");
			driver.quit();
		}
	}
}
