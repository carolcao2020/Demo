package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class SearchResultListPage extends BasePage {

	public SearchResultListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// The first good's picture
	@FindBy(xpath="//*[@id='J_goodsList']/ul/li[1]/div/div[1]/a/img")
	WebElement searchResult_firstItem_img;
	
	//The second good's picture
	@FindBy(xpath="//*[@id='J_goodsList']/ul/li[2]/div/div[1]/a/img")
	WebElement searchResult_secondItem_img;
	
	//The first good's price value
	@FindBy(xpath="//*[@id='J_goodsList']/ul/li[1]/div/div[3]/strong/i")
	WebElement searchResult_firstItme_price;
	
	//Click on the goods picture and go to the details page
	public GoodsDetailsPage clickItemImg() throws InterruptedException{
		click(searchResult_firstItem_img);
		Thread.sleep(1000);
		return new GoodsDetailsPage(driver);
	}
	
	//Get the good's price and compare to the price in details page
	
	public String getGoodsPriceOnListPage(){
		return searchResult_firstItme_price.getText();
	}

}
