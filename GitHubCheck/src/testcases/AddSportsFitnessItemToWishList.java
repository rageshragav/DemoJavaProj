package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.LoginPage;
import pages.SportsFitnessAndOutdoorPage;
import utils.Utility;

public class AddSportsFitnessItemToWishList extends BaseClass{
	public SportsFitnessAndOutdoorPage sportsFitnessAndOutdoorPage;
	public LoginPage loginPage;

@BeforeClass
public void createPOMObject() {

	sportsFitnessAndOutdoorPage = new SportsFitnessAndOutdoorPage(driver);
	loginPage = new pages.LoginPage(driver);

}

@Test(priority = 1)
public void LoginPage() throws IOException, InterruptedException {

	loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

}

@Test(priority = 2)
public void BestSellerBook()
		throws InterruptedException {
	extentTest = extent.createTest("Adding SportsFitness Item to wishlist  ");
	sportsFitnessAndOutdoorPage.addSportsItemToWishList();
	if (sportsFitnessAndOutdoorPage.isWishListWithSportsItemAdded()) {
		extentTest.log(Status.PASS, "Item added to wishlist successfully",Utility.captureScreenShot(driver));
		
	} else {
		extentTest.log(Status.FAIL, "Item not added to wishlist successfully",Utility.captureScreenShot(driver));
	}
	
	
}
}