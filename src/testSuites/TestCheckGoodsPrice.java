package testSuites;
import org.testng.annotations.Test;

import framework.BrowserEngine;
import pageObjects.GoodsDetailsPage;
import pageObjects.HomePage;
import pageObjects.SearchResultListPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestCheckGoodsPrice {
	WebDriver driver;
  @Test
  public void checkPrice() throws InterruptedException {
	  HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	  homepage.searchWithKeyword("iPhone");
	  
	  //Go to search result list page
	  SearchResultListPage srlp = PageFactory.initElements(driver, SearchResultListPage.class);
	  Thread.sleep(1000);
	  String price1 = srlp.getGoodsPriceOnListPage();
	  System.out.println(price1);
	  srlp.clickItemImg();
	  srlp.siwtchWindow();
	  
	  //Go to Good's details page
	  GoodsDetailsPage gdp = PageFactory.initElements(driver, GoodsDetailsPage.class);
	  Thread.sleep(1000);
	  String price2 = gdp.getPriceOnDetailsPage();
	  System.out.println(price2);
	  
	  Assert.assertEquals(price2, price1);
	  gdp.addGoodToCart();
	  
  }
  @BeforeClass
  public void seUp() throws IOException {
	  BrowserEngine browserEngine = new BrowserEngine();
	  browserEngine.initConfigData();
	  driver = browserEngine.getBrowser();
	  
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
