package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://data.pharmacodia.com/web/homePage/index?ns=1&ts=1&str=YWSJ");
		System.out.println("Current tab title is "+ driver.getTitle());
		Thread.sleep(1000);
		driver.switchTo().frame("rightMain");
		WebElement element = driver.findElement(By.xpath("//*/span[@title='化学药']"));
//		WebElement element = driver.findElement(By.xpath("//*[@id='search_top']/div[1]/div[1]/div/div/span[1]"));
		element.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id='noLoginAlert']/div/button")).click();
		driver.quit();
	}
}
