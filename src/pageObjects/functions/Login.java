package pageObjects.functions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.BrowserEngine;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Login {
	public WebDriver driver;
	
	//Get the browser type and open the browser and URL
	public void initSetUp() throws IOException{
		BrowserEngine browser = new BrowserEngine();
		browser.initConfigData();
		driver = browser.getBrowser();
	}
	
	//Loading the element in login page and click the login button by page factory class
	public void loginValid(){
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		//click the login link in homepage
		homepage.clickLoginLink();
		//Redirect to the login account page and initializing the login account page
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		//Login username and password
		loginpage.login("18600292841", "nihao2015");
	}
	public Login() {
		// TODO Auto-generated constructor stub
	}

}
