package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.BabyProductPage;
import pages.BestSellerItemPage;
import pages.LoginPage;
import utils.Utility;

public class AddBabyProductToCartViaWishList extends BaseClass {
	public BabyProductPage babyProductPage;
	public LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {

		babyProductPage = new BabyProductPage(driver);
		loginPage = new pages.LoginPage(driver);
		
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {
	
		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void BabyProduct()
			throws InterruptedException {
		extentTest = extent.createTest("Adding Baby Product to cart Via wishlist  ");
		babyProductPage.addBabyProductToWishList();
		if (babyProductPage.isWishListWithwarOfLankaAdded()) {
			extentTest.log(Status.PASS, "Product added to Cart successfully",Utility.captureScreenShot(driver));
			
		} else {
			extentTest.log(Status.FAIL, "Product not added to Cart successfully",Utility.captureScreenShot(driver));
		}
		
		
}
	
		   
}


