package lessons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickMenu {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='speed-button']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='speed-menu']/li/div"));
		for(WebElement elm : list){
			if(elm.getAttribute("innerHTML").equals("Fast")){
//				elm.getText()
				elm.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
