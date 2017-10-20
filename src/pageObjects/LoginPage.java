package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;
import pageObjects.HomePage;

public class LoginPage extends BasePage {
	// Login page: login account and password testing

	//Element FindBy
	//Click Account Login menu
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/div[2]/a")
	WebElement loginType_byAccount;
	
	//Account input box
	@FindBy(id="loginname")
	WebElement login_userName;
	
	//Password input box
	@FindBy(id="nloginpwd")
	WebElement login_password;
	
	//Login in Button
	@FindBy(id="loginsubmit")
	WebElement login_submitBtn;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	//Login in by username and password
	public HomePage login(String username, String password){
		click(loginType_byAccount);
		type(login_userName,username);
		type(login_password,password);
		click(login_submitBtn);
		return new HomePage(driver);
	}
}
