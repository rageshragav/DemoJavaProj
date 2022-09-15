package testcases;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BestSellerItemPage;
import pages.LoginPage;

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
		bestSellerItemPage.openbestSeller();
		bestSellerItemPage.openHotNewReleasesPage();
		bestSellerItemPage.getTextOfHotNewReleasesElement();
		bestSellerItemPage.clickOnBooks();
		bestSellerItemPage.clickOnactionAndAdeventure();
		bestSellerItemPage.clickOnwarOfLankaBook();
		bestSellerItemPage.clickOnAddToWishListButton();
		//bestSellerItemPage.clickOncreateListBtn();
		bestSellerItemPage.clickOnviewWishListBtn();
		bestSellerItemPage.clickOndeleteItemfromWishListBtn();
		

}
}


