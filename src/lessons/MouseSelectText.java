package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSelectText {

	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com/duty");
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//*/div[@class='dwri_bule']/table/tbody/tr/td/p"));
		WebElement element2 = driver.findElement(By.xpath("//*/div[@class='dwri_bule']/table/tbody/tr/td/ul/li[1]"));
		Actions action = new Actions(driver);
		action.clickAndHold(element1).moveToElement(element2).perform();
		action.release();
		Thread.sleep(2000);
		driver.quit();
	}
}
