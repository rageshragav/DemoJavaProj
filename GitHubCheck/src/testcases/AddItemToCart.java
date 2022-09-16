/**
 * 
 */
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAddressPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class AddItemToCart extends BaseClass {
	public NewAddressPage newAddressPage;
	public LoginPage loginPage;
	public HomePage homepage;
	public ProductDetailsPage productDetPage;
	public ShoppingCartPage shoppingCartPage;
	//public static String product = properties.getProperty("product");

	@BeforeClass
	public void createPOMObject() {

		newAddressPage = new NewAddressPage(driver);
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productDetPage = new ProductDetailsPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
	}

	@Test(priority = 1)
	public void loginToAmazon() {
		extentTest = extent.createTest("Valid login test");
		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));
		extentTest.pass("user login successfull");

	}

	@Test(priority = 2)
	public void searchItemAndAddToCart() throws InterruptedException {
		extentTest = extent.createTest("Add item to cart");
		homepage.searchItem(properties.getProperty("product"));
		homepage.clickOnSearchIcon();
		homepage.clickOnSearchResult();
		Utility.switchToNewWindow(driver);
		productDetPage.addItemToCart();

		if (shoppingCartPage.isProductInCart()) {
			extentTest.log(Status.PASS, "Product " + properties.getProperty("product") + " added to the cart successfully");

		} else {
			extentTest.log(Status.FAIL, "Product " + properties.getProperty("product") + " is not in the cart ");
		}

	}
}
