package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class GoodsDetailsPage extends BasePage{

	public GoodsDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Good's details page, compare the price and make the order operations and so on
	@FindBy(xpath="//*/span[@class='p-price']/span[2]")
	WebElement goods_price;
	
	@FindBy(id="InitCartUrl")
	WebElement addToCart_Btn;
	
	//Get the good's details price
	public String getPriceOnDetailsPage(){
		return goods_price.getText();
	}
	
	//Add to the shopCart by click the button
	public void addGoodToCart(){
		click(addToCart_Btn);
	}
}
