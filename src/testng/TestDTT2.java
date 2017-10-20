package testng;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class TestDTT2 {
  @Test(dataProvider = "testdata")
  public void TestLogin(String username, String password) throws InterruptedException {
	  System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
//	  System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
//	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.baidu.com");
	  
	  driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).clear();
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).clear();
	  driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_8__password']")).sendKeys(password);
	  driver.quit();
	  driver.quit();
  }

  @DataProvider(name="testdata")
  public Object[][] TestDataFeed() throws Exception {
	  File src = new File(".\\DataFiles\\test-data.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  
	  @SuppressWarnings("resource")
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh1 = wb.getSheetAt(0);
	  int numberrow = sh1.getPhysicalNumberOfRows();
	  
	  Object [][] baidudata = new Object[numberrow][2];
	  for(int i = 0; i<numberrow;i++){
		  baidudata[i][0]=sh1.getRow(i).getCell(0).getStringCellValue();
		  baidudata[i][1]=sh1.getRow(i).getCell(1).getStringCellValue();
		}
	  return baidudata;
  }
}
