package testSuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.LogType;
import framework.Logger;

public class TestBaiduJavaLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Logger.Output(LogType.LogTypeName.INFO, "启动Chrome浏览器");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Logger.Output(LogType.LogTypeName.INFO, "设置等待十秒钟");
		
		driver.manage().window().maximize();
		Logger.Output(LogType.LogTypeName.INFO, "浏览器window最大化");
		
		driver.get("http://www.baidu.com");
		Logger.Output(LogType.LogTypeName.INFO, "打开百度首页");
		
		driver.findElement(By.id("kw")).sendKeys("Selenium");
		Logger.Output(LogType.LogTypeName.INFO, "输入搜索关键字Selenium");
		
		driver.quit();
		Logger.Output(LogType.LogTypeName.INFO, "关闭浏览器");
	}

}
