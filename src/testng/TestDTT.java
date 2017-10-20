package testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDTT {
  @Test(dataProvider = "testdata")
  public void TestLogin(String username, String password) throws InterruptedException{
	  System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.baidu.com");
	  
	  driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).clear();
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).clear();
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).sendKeys(password);
	  driver.quit();
  }

  @DataProvider(name="testdata")
  public Object[][] TestDataFeed() {
	  Object [][] baidudata = new Object[2][2];
	  baidudata[0][0]="Selenium1@baidu";
	  baidudata[0][1]="Password1";
	  baidudata[1][0]="Selenium2@baidu";
	  baidudata[1][1]="Password2";
	  return baidudata;
  }
}
