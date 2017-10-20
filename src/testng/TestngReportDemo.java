package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Reporter;
public class TestngReportDemo {
  @Test
  public void testReport() {
	  WebDriver driver = new ChromeDriver();
	  Reporter.log("Launch chrome browser instance");
	  driver.manage().window().maximize();
	  Reporter.log("Maximize the window");
	  driver.get("http://www.baidu.com");
	  Reporter.log("Open Baidu index page");
	  driver.quit();
	  Reporter.log("Close and quite browser");  
  }
}
