package testSuites;

import org.testng.annotations.Test;

import pageObjects.JDHomePage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class TestWithPO {
	WebDriver driver;
  @Test
  public void testLogin() {
	  JDHomePage hp = PageFactory.initElements(driver, JDHomePage.class); 
	  hp.login("user1", "123");
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
