package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BestSellerItemPage;
import pages.LoginPage;
import pages.ViewOrdersPage;

public class ViewOrders extends BaseClass {
	public BestSellerItemPage bestSellerItemPage;
	public LoginPage loginPage;
	public ViewOrdersPage viewOrdersPage;

 



@BeforeClass
	public void createPOMObject() {

	bestSellerItemPage = new BestSellerItemPage(driver);
		loginPage = new LoginPage(driver);
		viewOrdersPage = new ViewOrdersPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void ViewOrdersPage() {
		viewOrdersPage.clickOnOrderBox();
		viewOrdersPage.clickOnbuyAgain();
		viewOrdersPage.clickOnnotYetShipped();
		viewOrdersPage.clickOncancelledOrders();
	}	
}
