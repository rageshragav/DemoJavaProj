/**
 * 
 */
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAddressPage;
import pages.ProductDetailsPage;
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

	@BeforeClass
	public void createPOMObject() {

		newAddressPage = new NewAddressPage(driver);
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productDetPage = new ProductDetailsPage(driver);
	}

	@Test(priority = 1)
	public void loginToAmazon() {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void searchItemAndAddToCart() throws InterruptedException {
		homepage.searchItem("iphone 12");
		homepage.clickOnSearchIcon();
		homepage.clickOnSearchResult();
		Utility.switchToNewWindow(driver);
		productDetPage.addItemToCart();
		
		
	}
}
