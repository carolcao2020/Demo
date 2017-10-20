package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageLoadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Point set window size
//		Point targetPosition = new Point(200,30);
//		driver.manage().window().setPosition(targetPosition);
		//Dimension set window size
//		Dimension targetSize = new Dimension(100,700);
//		driver.manage().window().setSize(targetSize);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		System.out.println("Current tab title is "+ driver.getTitle());
		try{
			String baidu_title = "百度一下，你就知道";
			assert baidu_title == driver.getTitle();
			System.out.println("Test Pass");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Test Fail");
		}
		driver.navigate().to("http://news.baidu.com");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
//		Full screen
//		driver.findElement(By.tagName("body")).sendKeys(Keys.F11); 
		driver.quit();
	}

}
