package testSuites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.GoodsDetailsPage;
import pageObjects.SearchResultListPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Test_AddGoodToCart {
  @Test
  public void testAddToCart() throws InterruptedException {
	  SearchResultListPage srlp = PageFactory.initElements(Test_HomePage_Search.driver, SearchResultListPage.class);
	  srlp.clickItemImg();
	  
	  //Switch to the Good detail page
	  srlp.siwtchWindow();
	  
	  GoodsDetailsPage gdp = PageFactory.initElements(Test_HomePage_Search.driver, GoodsDetailsPage.class);
	  gdp.addGoodToCart();
  }
  
@BeforeClass
  public void setUp() {
  }

@AfterClass
  public void tearDown() {
	  Test_HomePage_Search.driver.quit();
  }
}
