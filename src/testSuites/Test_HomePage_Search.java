package testSuites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.functions.Login;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Test_HomePage_Search {
	public static WebDriver driver;
  @Test
  public void test_searchGoods() throws InterruptedException {
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  hp.searchWithKeyword("Java");
  }
  @BeforeMethod
@BeforeClass
  public void setUp() throws IOException {
	  Login login = new Login();
	  login.initSetUp();
	  login.loginValid();
	  driver = login.driver;
  }

  @AfterMethod
@AfterClass
  public void tearDown() throws InterruptedException {
//	  driver.quit();
	  Thread.sleep(3000);
  }

}
