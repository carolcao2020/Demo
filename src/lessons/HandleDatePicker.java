package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleDatePicker {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/datepicker/default.html"); 
		Thread.sleep(2000);
		WebElement date_inputbox = driver.findElement(By.id("datepicker"));
		date_inputbox.click();
		//next month
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[@data-handler='next']")).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a")).click();
		Thread.sleep(2000);
		date_inputbox.clear();
		date_inputbox.sendKeys("08/17/2017");
		Thread.sleep(2000);
		driver.quit();
	}
}
