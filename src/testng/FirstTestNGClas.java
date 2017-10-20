package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class FirstTestNGClas {
	WebDriver driver;
  @Test
  public void OpenBaidu() {
	  driver.get("http://www.baidu.com");
	  driver.findElement(By.id("kw")).sendKeys("selenium");
	  driver.findElement(By.id("su")).click();
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
