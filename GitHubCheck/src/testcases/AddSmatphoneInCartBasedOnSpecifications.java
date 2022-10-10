package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.SmartPhonePage;
import utils.Log;
import utils.Utility;
import pages.LoginPage;

public class AddSmatphoneInCartBasedOnSpecifications extends BaseClass {
	public SmartPhonePage smartPhonePage;
	public LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {

		smartPhonePage = new SmartPhonePage(driver);
		loginPage = new pages.LoginPage(driver);
		
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {
	
		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}
	@Test(priority = 2)
	public void SmartPhoneProduct()
			throws InterruptedException {
		extentTest = extent.createTest("Adding Smartphone product to cart Via wishlist  ");
		smartPhonePage.addSmartPhoneToWishList();
		if (smartPhonePage.isWishListWithSmartPhoneAdded()) {
			extentTest.log(Status.PASS, "Product added to Cart successfully",Utility.captureScreenShot(driver));
			
		} else {
			extentTest.log(Status.FAIL, "Product not added to Cart successfully",Utility.captureScreenShot(driver));
		}
		smartPhonePage.addToCartViaWishList();
		smartPhonePage.proceedToCheckoutFromWishList();
		smartPhonePage.deleteItemFromCart();
		
		if (smartPhonePage.isItemDeleted()) {
			extentTest.log(Status.PASS, "Item deleted from the cart successfully", Utility.captureScreenShot(driver));
			Log.info("Item deleted from the cart successfully",className);
		} else {
			extentTest.log(Status.FAIL, "Item not deleted from the cart successfully",
					Utility.captureScreenShot(driver));
			Log.error("Item not deleted from the cart successfully",className);
		}
	}	
}
