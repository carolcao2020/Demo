package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
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
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("Java");
		//by classname
//		driver.findElement(By.className("s_ipt")).sendKeys("Java");
		//by name
//		driver.findElement(By.name("wd")).sendKeys("Java");
		//by css selector #id
//		driver.findElement(By.cssSelector("#kw")).sendKeys("Java");
		driver.findElement(By.id("su")).click();
		//by classname, the name cannot contains space, so the error will occur and use other way to find element
//		driver.findElement(By.className("bg s_btn_wr")).click();
		//by css selector #id
//		driver.findElement(By.cssSelector("#su")).click();
		driver.quit();
	}

}
