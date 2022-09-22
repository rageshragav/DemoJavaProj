package testcases;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.BestSellerItemPage;
import pages.LoginPage;
import utils.Utility;

public class AddBestSellerItemToWishList extends BaseClass {
	public BestSellerItemPage bestSellerItemPage;
	public LoginPage loginPage;

 



@BeforeClass
	public void createPOMObject() {

	bestSellerItemPage = new BestSellerItemPage(driver);
		loginPage = new pages.LoginPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void BestSellerBook()
			throws InterruptedException {
		extentTest = extent.createTest("Adding best Seller item to wishlist  ");
		bestSellerItemPage.addBestSellerBookToWishList();
		if (bestSellerItemPage.isWishListWithwarOfLankaAdded()) {
			extentTest.log(Status.PASS, "Item added to wishlist successfully",Utility.captureScreenShot(driver));
			
		} else {
			extentTest.log(Status.FAIL, "Item not added to wishlist successfully",Utility.captureScreenShot(driver));
		}
		
		
}
}