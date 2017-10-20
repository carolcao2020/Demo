package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserEngine {
	public String browserName;
	public String serverURL;
	public WebDriver driver;
	
	public void initConfigData() throws IOException{
		Properties p = new Properties();
		
		InputStream ips = new FileInputStream(".\\DataFiles\\config.properties");
		p.load(ips);
		
		Logger.Output(LogType.LogTypeName.INFO, "Start to select browser name from properties file");
		browserName = p.getProperty("browserName");
		Logger.Output(LogType.LogTypeName.INFO, "You had selected test browser type is: " + browserName);
		serverURL = p.getProperty("serverUrl");
		Logger.Output(LogType.LogTypeName.INFO, "The server URL is: " + serverURL);
		ips.close();
	}
	
	public WebDriver getBrowser(){
		if(browserName.equalsIgnoreCase("Firefox")){
//			System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette",".\\Tools\\geckodriver.exe");
			driver = new FirefoxDriver();
//			driver = createNewFirefoxDriver();
			Logger.Output(LogType.LogTypeName.INFO,"Launching Firefox....");	
		}else if(browserName.equalsIgnoreCase("Chrome")){
			System.getProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
			driver = new ChromeDriver();
			Logger.Output(LogType.LogTypeName.INFO,"Launching Chrome....");	
		}else if(browserName.equalsIgnoreCase("IE")){
			System.getProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Logger.Output(LogType.LogTypeName.INFO,"Launching IE....");
		}
		driver.get(serverURL);
		Logger.Output(LogType.LogTypeName.INFO, "Open URL： " + serverURL);;
		driver.manage().window().maximize();
		Logger.Output(LogType.LogTypeName.INFO, "Maximize the browser....");
		callWait(5);
		return driver;
	}
	
	private WebDriver createNewFirefoxDriver() {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("prefs.converted-to-utf8", true);
		firefoxProfile.setPreference("browser.download.dir", ".\\TestDownload");
		
		try{
			driver = new FirefoxDriver(firefoxProfile);
		}catch (Exception e){
			Logger.Output(LogType.LogTypeName.ERROR, e.getMessage());
			Logger.Output(LogType.LogTypeName.INFO, "Failed to initilize the Firefox driver");
		}
		return driver;
	}

	public void tearDown() throws InterruptedException{
		Logger.Output(LogType.LogTypeName.INFO, "Closing browser...");
		driver.quit();
		Thread.sleep(3000);
	}

	public void callWait(int time) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Logger.Output(LogType.LogTypeName.INFO, "Wait for " + time + "seconds.");
	}
}
