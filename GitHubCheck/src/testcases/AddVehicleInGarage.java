/**
 * 
 */
package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.VehicleGaragePage;

/**
 * @author ragesh
 *
 */
public class AddVehicleInGarage extends BaseClass {

	public VehicleGaragePage vehicleGaragePage;
	public LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {

		vehicleGaragePage = new VehicleGaragePage(driver);
		loginPage = new pages.LoginPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2)
	public void AddNewVehicle() throws IOException, InterruptedException {

		// driver.get(properties.getProperty("garageurl"));
		driver.navigate().to(properties.getProperty("garageurl"));
		vehicleGaragePage.addFirstVehicle();
		vehicleGaragePage.selectVehicleType();
		vehicleGaragePage.selectVehicleBrand();
		vehicleGaragePage.selectVehicleModel();
		vehicleGaragePage.selectVehicleVariant();
		vehicleGaragePage.saveNewVehicle();

		if (vehicleGaragePage.getVehicleTitle()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
		vehicleGaragePage.removeVehicle();

		if (vehicleGaragePage.getMainPageTitle()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		Thread.sleep(3000);

	}

}
