/**
 * 
 */
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.BestSellerItemPage;
import pages.HomeImprovementPage;
import pages.LoginPage;

/**
 * @author ragesh
 *
 */
public class AddHomeImprovementItemsToWishList extends BaseClass {

	public HomeImprovementPage homeImprovementPage;
	public LoginPage loginPage;
	public BestSellerItemPage bestSellerItemPage;

	@BeforeClass
	public void createPOMObject() {

		homeImprovementPage = new HomeImprovementPage(driver);
		loginPage = new pages.LoginPage(driver);
		bestSellerItemPage = new BestSellerItemPage(driver);
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void addHomeImprovementsToWishList() throws IOException, InterruptedException {
		extentTest = extent.createTest("Adding home improvement item to wishlist and from wishlist to cart ");

		homeImprovementPage.selectHomeImprovementItem();
		homeImprovementPage.addBroomToWishList();
		homeImprovementPage.viewWishList();
		if (homeImprovementPage.isWishListWithBroomAdded()) {
			extentTest.log(Status.PASS, "Item added to wishlist successfully");
		}else {
			extentTest.log(Status.FAIL, "Item not added to wishlist successfully");
		}
		homeImprovementPage.addToCartViaWishList();
		homeImprovementPage.proceedToCheckoutFromWishList();

	}

}
