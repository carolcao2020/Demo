package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadAutoIt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/span[@class='soutu-btn']")).click();
		driver.findElement(By.xpath("//*/input[@class='upload-pic']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(".\\Tools\\UploadFile.exe");
		Thread.sleep(8000);
		driver.quit();
	}
}
