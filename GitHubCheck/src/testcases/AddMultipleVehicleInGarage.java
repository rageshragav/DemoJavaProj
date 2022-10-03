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
import pages.MultipleVehicleGaragePage;
import pages.VehicleGaragePage;
import testdataprovider.TestDataProvider;

/**
 * @author ragesh
 *
 */
public class AddMultipleVehicleInGarage extends BaseClass {

	public MultipleVehicleGaragePage multipleVehicleGaragePage;
	public LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {

		multipleVehicleGaragePage = new MultipleVehicleGaragePage(driver);
		loginPage = new pages.LoginPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(dataProvider = "vehicledata", dataProviderClass = TestDataProvider.class, priority = 2)
	public void AddNewVehicle(String type,String brand,String model,String variant) throws IOException, InterruptedException {

		// driver.get(properties.getProperty("garageurl"));
		driver.navigate().to(properties.getProperty("garageurl"));
		multipleVehicleGaragePage.addFirstVehicle();
		multipleVehicleGaragePage.selectVehicleType(type);
		multipleVehicleGaragePage.selectVehicleBrand(brand);
		multipleVehicleGaragePage.selectVehicleModel(model);
		multipleVehicleGaragePage.selectVehicleVariant(variant);
		multipleVehicleGaragePage.saveNewVehicle();

		if (multipleVehicleGaragePage.getVehicleTitle(brand,model)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
		multipleVehicleGaragePage.removeVehicle();

		if (multipleVehicleGaragePage.getMainPageTitle()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		Thread.sleep(3000);

	}

}
