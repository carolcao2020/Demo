package testSuites;

import org.testng.annotations.Test;

import pageObjects.JDHomePageNo;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestWithoutPO {
	WebDriver driver;
  @Test
  public void testLogin() { 
	  JDHomePageNo hp = new JDHomePageNo(driver);
	  hp.clickLoginlink();
	  hp.clickLoginAccount();
	  hp.inputUsername("abc");
	  hp.inputPassword("123");
	  hp.clickSubmit();
  }
  @BeforeClass
  public void setUp() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.jd.com");
	  Thread.sleep(2000);
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
