package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JDHomePageNo {
	WebDriver driver;
	By login_link = By.id("ttbar-login");
	
	By login_withAccount = By.xpath("//*/div[@class='login-form']/div[2]/a");
	
	By inputBox_username = By.id("loginname");
	
	By inputBox_password = By.id("nloginpwd");
	
	By login_submitBtn = By.id("loginsubmit");
	
	public JDHomePageNo(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickLoginlink(){
		driver.findElement(login_link).click();
	}
	public void clickLoginAccount(){
		driver.findElement(login_withAccount).click();
	}
	public void inputUsername(String username){
		driver.findElement(inputBox_username).sendKeys(username);
	}
	public void inputPassword(String password){
		driver.findElement(inputBox_password).sendKeys(password);
	}
	public void clickSubmit(){
		driver.findElement(login_submitBtn).click();
	}
}
