package testcases;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BestSellerPage;
import pages.LoginPage;

public class AddBestSellerItemToWishList extends BaseClass {
	public BestSellerPage bestSellerPage;
	public LoginPage loginPage;

 



@BeforeClass
	public void createPOMObject() {

	bestSellerPage = new BestSellerPage(driver);
		loginPage = new pages.LoginPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void BestSellerBook()
			throws InterruptedException {
		bestSellerPage.openbestSeller();
		bestSellerPage.openHotNewReleasesPage();
		bestSellerPage.getTextOfHotNewReleasesElement();
		bestSellerPage.clickOnBooks();
		bestSellerPage.clickOnactionAndAdeventure();
		bestSellerPage.clickOnwarOfLankaBook();
		bestSellerPage.clickOnAddToWishListButton();
		

}
}


