package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestngDepend {
	WebDriver driver;
  @Test
  public void openBaidu() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Thread.sleep(2000);
	  System.out.println(driver.getTitle());
  }
  
  @Test(dependsOnMethods={"openBaidu"})
  public void testSearch() throws InterruptedException {
	  driver.findElement(By.id("kw")).sendKeys("selenium");
	  driver.findElement(By.id("su")).click();
	  System.out.println(driver.getTitle());
	  Thread.sleep(2000);
  }
//  @Test(enabled=false)
  @Test(dependsOnMethods={"testSearch"})
  public void testSearch2() throws InterruptedException {
	  driver.findElement(By.id("kw")).clear();
	  driver.findElement(By.id("kw")).sendKeys("selenium+java");
	  driver.findElement(By.id("su")).click();
	  System.out.println(driver.getTitle());
	  Thread.sleep(2000);
  }
  @BeforeClass
  public void setUp() {
	  System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
