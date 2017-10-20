package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JDHomePage {
	@FindBy(id="ttbar-login")
	WebElement login_link;
	
	@FindBy(xpath="//*/div[@class='login-form']/div[2]/a")
	WebElement login_withAccount;
	
	@FindBy(id="loginname")
	WebElement inputBox_username;
	
	@FindBy(id="nloginpwd")
	WebElement inputBox_password;
	
	@FindBy(id="loginsubmit")
	WebElement login_submitBtn;
	
	public void login(String username, String password){
		login_link.click();
		login_withAccount.click();
		inputBox_username.sendKeys(username);
		inputBox_password.sendKeys(password);
		login_submitBtn.click();
	}
}
