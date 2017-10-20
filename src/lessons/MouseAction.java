package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		Thread.sleep(2000);
//		WebElement settings = driver.findElement(By.xpath("//*[@id='u1']/a[8]"));
//		Actions action = new Actions(driver);
//		action.moveToElement(settings).perform();
//		driver.findElement(By.linkText("高级搜索")).click();
		driver.findElement(By.id("kw")).sendKeys("selenium a");
		WebElement auto_text = driver.findElement(By.xpath("//*[@id='form']/div/ul/li[@data-key='selenium api 中文']"));
		Actions action = new Actions(driver);
		action.moveToElement(auto_text).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
