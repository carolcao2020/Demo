package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollBarJS {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://blog.csdn.net/u011541946/article/details/73656609");
		System.out.println("Current tab title is "+ driver.getTitle());
		WebElement element = driver.findElement(By.xpath("//*[@id='pub_footerall']/dl/dd[1]/a[1]"));
//		WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		driver.quit();
	}

}
