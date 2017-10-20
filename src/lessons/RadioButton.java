package lessons;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	@SuppressWarnings("unchecked")
	public static <JavascriptExcutor> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver","\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//		driver.get("http://news.baidu.com/");
//		System.out.println("Current tab title is "+ driver.getTitle());
//		Thread.sleep(1000);
//		ArrayList<WebElement> search_type = (ArrayList<WebElement>)driver.findElements
//		(By.xpath("//*/p[@class='search-radios']/input"));
//		for(WebElement elem : search_type){
//			elem.click();
//			Thread.sleep(1000);
//		}
		driver.get("https://www.sojump.com/m/2792226.aspx/#");
		System.out.println("Current tab title is "+ driver.getTitle());
		Thread.sleep(1000);
		ArrayList<WebElement> radioGroup = (ArrayList<WebElement>)driver.findElement
				(By.xpath("//*/div[@id='divQuestion']/fieldset/div/div/div/span/input/../a"));
		for(WebElement elem : radioGroup){
			elem.click();
			Thread.sleep(1000);
		}
		driver.quit();
	}
}
