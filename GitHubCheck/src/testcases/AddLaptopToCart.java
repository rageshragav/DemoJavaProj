/**
 * 
 */
package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class AddLaptopToCart extends BaseClass {
	public LoginPage loginPage;
	public HomePage homePage;
	public ElectronicsPage electronicsPage;
	public ProductDetailsPage productDetailsPage;
	public String className = this.getClass().getSimpleName();

	@BeforeClass
	public void createPOMObject() {

		homePage = new HomePage(driver);
		loginPage = new pages.LoginPage(driver);
		electronicsPage = new ElectronicsPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);

		

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void addLaptopToWishList() throws IOException, InterruptedException {
		homePage.clickHamburgerMenuItem();
		homePage.clickComputerMenuItem();
		homePage.clickLaptopMenuItem();
		electronicsPage.selectScreenType();
		electronicsPage.selectLaptopBrand();
		electronicsPage.selectLaptopWeight();
		electronicsPage.selectLaptopCPU();
		electronicsPage.selectLaptopRAM();
		electronicsPage.selectLaptop();
		Utility.switchToNewWindow(driver);
		productDetailsPage.addToCartButton.click();
		Thread.sleep(2000);
	}

}
