package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;
import framework.LogType;
import framework.Logger;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Search input box
	@FindBy(id="key")
	WebElement search_inputBox;
	
	//Search button
	@FindBy(xpath="//*[@id='search']/div/div[2]/button")
	WebElement search_submitBtn;
	
	//Login link
	@FindBy(xpath="//*[@id='ttbar-login']/a[1]")
	WebElement login_link;
	
	//Type keywords in search input box, and click search icon button
	public SearchResultListPage searchWithKeyword(String keyword) throws InterruptedException{
		type(search_inputBox,keyword);
		Logger.Output(LogType.LogTypeName.INFO, "Input keyword successfully");
		click(search_submitBtn);
		Thread.sleep(2000);
		Logger.Output(LogType.LogTypeName.INFO, "Click search icon successfully");
		return new SearchResultListPage(driver);
	}
	
	//Click Login link
	public LoginPage clickLoginLink(){
		click(login_link);
		return new LoginPage(driver);
	}
	
	

}
