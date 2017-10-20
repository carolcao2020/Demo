package framework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	public static WebDriver driver;
	public static String pageTitle;
	public static String pageUrl;
	
	protected BasePage(WebDriver driver){
		BasePage.driver = driver;
	}
	
	protected void type(WebElement element,String text){
		try{
			if(element.isEnabled()){
				element.clear();
				Logger.Output(LogType.LogTypeName.INFO, "Clean the value if any in " + element.toString());
				element.sendKeys(text);
				Logger.Output(LogType.LogTypeName.INFO, "Type value is: " + text + ".");
			}
		}catch (Exception e){
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
		}
	}
	
	protected void click(WebElement element){
		try{
			if(element.isEnabled()){
				element.click();
				Logger.Output(LogType.LogTypeName.INFO, "Element " + element.toString() + " was clicked.");
			}
		}catch (Exception e){
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
		}
	}
	
	protected void clear(WebElement element){
		try{
			if(element.isEnabled()){
				element.clear();
				Logger.Output(LogType.LogTypeName.INFO, "Element " + element.toString() + " was cleaned.");
			}
		}catch (Exception e){
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
		}
	}
	
	protected void verifyElementIsPresent(WebElement element){
		try{
			if(element.isDisplayed()){
				Logger.Output(LogType.LogTypeName.INFO, "This Element "+ element.toString().trim() + " is present.");
			}
		}catch(Exception e){
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
		}
	}
	
	protected String getCurrentPageTitle(){
		pageTitle = driver.getTitle();
		Logger.Output(LogType.LogTypeName.INFO, "Current page title is " + pageTitle);
		return pageTitle;
	}
	
	protected String getCurrentPageUrl(){
		pageUrl = driver.getCurrentUrl();
		Logger.Output(LogType.LogTypeName.INFO, "Current page url is " + pageUrl);
		return pageUrl;
	}
	
	public void siwtchWindow(){
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Logger.Output(LogType.LogTypeName.INFO, "当前窗口数量： " + handles.size());
		Iterator<String> it = handles.iterator();
		while(it.hasNext()){
			if(currentWindow == it.next()){
				continue;
			}
			try{
				driver.close();
				WebDriver window = driver.switchTo().window(it.next());
				Logger.Output(LogType.LogTypeName.INFO, "New page title is  " + window.getTitle());
			}catch(Exception e){
				Logger.Output(LogType.LogTypeName.INFO, "无法切换到新打开的窗口" + e.getMessage());
			}
		}
		
	}

}
