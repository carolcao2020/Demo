package lessons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElement_List {

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
		driver.findElement(By.linkText("新闻")).click();
		Thread.sleep(2000);
		assert driver.getCurrentUrl() == "http://news.baidu.com";
		String str = driver.findElement(By.xpath(".//*[@id='pane-news']/div/ul/li[2]/a")).getText();
		System.out.println(str);
//		List <WebElement> links = driver.findElements(By.xpath(".//*[@id='pane-news']/div/ul/li[2]/a"));
		List <WebElement> links = driver.findElements(By.xpath(".//*[@id='pane-news']/ul[1]/li/a"));
		for(int i = 0; i< links.size(); i++){
			System.out.println(links.get(i).getText());
		}
		driver.quit();
	}

}
