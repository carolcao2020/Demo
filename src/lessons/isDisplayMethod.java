package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class isDisplayMethod {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		System.out.println("Current tab title is "+ driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
		Thread.sleep(1000);
		WebElement userName = driver.findElement(By.id("TANGRAM__PSP_8__userName"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		userName.sendKeys("abc");
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",userName);  
		WebElement password = driver.findElement(By.id("TANGRAM__PSP_8__password"));
		password.sendKeys("123");
		js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", password);
		Thread.sleep(1000);
		driver.quit();
	}
}
