/**
 * 
 */
package testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ToysGamesPage;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class AddMultipleCategItems extends BaseClass {
	public LoginPage loginPage;
	public HomePage homePage;
	public ProductDetailsPage productDetailsPage;
	public ToysGamesPage toysGamesPage;
	public String className = this.getClass().getSimpleName();

	@BeforeClass
	public void createPOMObject() {

		homePage = new HomePage(driver);
		loginPage = new pages.LoginPage(driver);
		toysGamesPage = new ToysGamesPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	 @Test(priority = 2)
	public void addEchoDottoCart() throws IOException, InterruptedException {

		homePage.clickHamburgerMenuItem();
		homePage.clickEchoMenuItem();
		homePage.clickEchoDotItem();
		productDetailsPage.addToCart();

	}

	 @Test(priority = 3)
	public void addFireSticktoCart() throws IOException, InterruptedException {

		homePage.clickHamburgerMenuItem();
		homePage.clickFireTvItem();
		homePage.clickFireTvGen();
		productDetailsPage.addToCart();

	}

	@Test(priority = 4)
	public void addToyToCart() throws IOException, InterruptedException {

		homePage.clickHamburgerMenuItem();
		homePage.seeAllMenu();
		homePage.clickToysMenu();
		homePage.clickToysGamesMenu();
		toysGamesPage.filterAgeGroup();
		toysGamesPage.filterDeliveryDay();
		toysGamesPage.filterTiyCharacter();
		toysGamesPage.clickToyTeddy();
		Utility.switchToNewWindow(driver);
		productDetailsPage.addToCart();
		Thread.sleep(3000);
	}

}
