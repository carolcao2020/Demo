package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleAlert {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://news.cyol.com/node_60799.htm"); 
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());  
	    driver.switchTo().alert().accept();
		driver.quit();
	}
}
