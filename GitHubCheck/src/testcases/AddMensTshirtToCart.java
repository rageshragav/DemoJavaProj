package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.LoginPage;
import pages.MensTshirtPage;
import utils.Log;
import utils.Utility;

public class AddMensTshirtToCart extends BaseClass{
	public MensTshirtPage mensTshirtPage;
	public LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {

		mensTshirtPage = new MensTshirtPage(driver);
		loginPage = new pages.LoginPage(driver);
		
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {
	
		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}
	@Test(priority = 2)
	public void MensTshirtProduct()
			throws InterruptedException {
		extentTest = extent.createTest("Adding MensTshirt Product to cart Via wishlist  ");
		mensTshirtPage.addMensTshirtToWishList();
		if (mensTshirtPage.isWishListWithMensTshirtAdded()) {
			extentTest.log(Status.PASS, "Product added to Cart successfully",Utility.captureScreenShot(driver));
			
		} 
		else {
			extentTest.log(Status.FAIL, "Product not added to Cart successfully",Utility.captureScreenShot(driver));
		}
		mensTshirtPage.addToCartViaWishList();
		mensTshirtPage.proceedToCheckoutFromWishList();
		mensTshirtPage.deleteItemFromCart();
		
		if (mensTshirtPage.isItemDeleted()) {
			extentTest.log(Status.PASS, "Item deleted from the cart successfully", Utility.captureScreenShot(driver));
			Log.info("Item deleted from the cart successfully",className);
		} else {
			extentTest.log(Status.FAIL, "Item not deleted from the cart successfully",
					Utility.captureScreenShot(driver));
			Log.error("Item not deleted from the cart successfully",className);
		}
 }
}