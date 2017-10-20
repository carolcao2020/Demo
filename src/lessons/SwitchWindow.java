package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.jd.com");
		System.out.println("Current tab title is "+ driver.getTitle());
		WebElement phone_link = driver.findElement(By.linkText("手机"));
		phone_link.click();
		Thread.sleep(2000);
		String handle = driver.getWindowHandle();
//		for(String handles : driver.getWindowHandles()){
//			if(handles.equals(handle))
//				continue;
//			driver.switchTo().window(handles);
//		}
		for(String handles : driver.getWindowHandles()){
			if (!handles.equals(handle))
				driver.close();
			driver.switchTo().window(handles);
		}
		WebElement xiaomi_link = driver.findElement(By.linkText("小米"));
		xiaomi_link.click();
		Thread.sleep(2000);;
		driver.quit();
	}

}
