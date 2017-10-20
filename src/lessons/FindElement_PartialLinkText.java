package lessons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElement_PartialLinkText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		// get the window handle string for "百度"
		System.out.println(driver.getWindowHandle());
		System.out.println("Current tab title is "+ driver.getTitle());
		try{
			String baidu_title = "百度一下，你就知道";
			assert baidu_title == driver.getTitle();
			System.out.println("Test Pass");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Test Fail");
		}
		driver.findElement(By.partialLinkText("设为主页")).click();
		Thread.sleep(2000);
		assert driver.getCurrentUrl() == "https://www.baidu.com/cache/sethelp/help.html";
		// get the window handle string for "设为主页"
		System.out.println(driver.getWindowHandle());
		//close current driver page "百度"
//		driver.close();
		//Close all the open driver page
		driver.quit();
	}

}
