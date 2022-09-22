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
import utils.Log;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class AddHomeImprovementItemsToWishList extends BaseClass {

	public HomeImprovementPage homeImprovementPage;
	public LoginPage loginPage;
	public BestSellerItemPage bestSellerItemPage;
	public String className = this.getClass().getSimpleName();
	

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
		extentTest = extent.createTest("Adding home improvement item to wishlist and moving from wishlist to cart ");

		homeImprovementPage.selectHomeImprovementItem();

		homeImprovementPage.addBroomToWishList();
		homeImprovementPage.viewWishList();
		if (homeImprovementPage.isWishListWithBroomAdded()) {
			extentTest.log(Status.PASS, "Item added to wishlist successfully", Utility.captureScreenShot(driver));
			Log.info("Item moved to wishlist successfully",className);

		} else {
			extentTest.log(Status.FAIL, "Item not added to wishlist successfully", Utility.captureScreenShot(driver));
			Log.error("Item not moved to wishlist successfully",className);
		}
		homeImprovementPage.addToCartViaWishList();
		homeImprovementPage.proceedToCheckoutFromWishList();
		homeImprovementPage.deleteItemFromCart();

		if (homeImprovementPage.isItemDeleted()) {
			extentTest.log(Status.PASS, "Item deleted from the cart successfully", Utility.captureScreenShot(driver));
			Log.info("Item deleted from the cart successfully",className);
		} else {
			extentTest.log(Status.FAIL, "Item not deleted from the cart successfully",
					Utility.captureScreenShot(driver));
			Log.error("Item not deleted from the cart successfully",className);
		}

	}

}
