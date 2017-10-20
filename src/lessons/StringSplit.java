package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import library.MyWait;

public class StringSplit {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		driver.findElement(By.id("su")).click();
		WebElement result = driver.findElement(By.xpath("//*/div[@class='nums']"));
		String resultText = result.getText();
		String str1 = resultText.split("约")[1];
		String num = str1.split("个")[0];
		System.out.println(num);
		driver.quit();
	}
}
