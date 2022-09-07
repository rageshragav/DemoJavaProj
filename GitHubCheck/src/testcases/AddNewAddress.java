/**
 * 
 */
package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAddressPage;
import utils.Utility;
import utils.XLUtils;

/**
 * @author ragesh
 *
 */
public class AddNewAddress extends BaseClass {

	public NewAddressPage newAddressPage;
	public LoginPage loginPage;

	@DataProvider(name = "addressdata")
	String[][] getData() throws IOException {
		String path = "./resources/addressdata.xlsx";
		int row = XLUtils.getRowCount(path, "Sheet1");
		int column = XLUtils.getCellCount(path, "Sheet1", 1);

		String addressdata[][] = new String[row][column];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < column; j++) {
				addressdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return addressdata;

	}

	@BeforeClass
	public void createPOMObject() {

		newAddressPage = new NewAddressPage(driver);
		loginPage = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void LoginPage() throws IOException, InterruptedException {

		loginPage.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));

	}

	@Test(priority = 2, dataProvider = "addressdata")
	public void createNewAddress(String custName, String mobile, String pin, String flat, String area, String landmark)
			throws InterruptedException {

		newAddressPage.customerProfile.click();
		newAddressPage.clickOnYourAddressBar();
		newAddressPage.clickOnAddAddress();
		newAddressPage.enterCustomerName(custName);
		newAddressPage.fillMobileNumber(mobile);
		newAddressPage.fillPinCode(pin);
		newAddressPage.fillFlat(flat);
		newAddressPage.fillArea(area);
		newAddressPage.fillLandmark(landmark);
		Utility.javaScriptExecuterScrollDownPage(driver, 200);
		newAddressPage.clickOnAddAdressButton();
		
		driver.get("https://www.amazon.in/a/addresses?ref_=ya_d_c_addr");

		/*
		 * WebElement frame1 = driver.findElement(By.id(
		 * "google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		 * driver.switchTo().frame(frame1); WebElement frame2 =
		 * driver.findElement(By.id("ad_iframe")); driver.switchTo().frame(frame2);
		 * driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		 * driver.switchTo().defaultContent();
		 */

		Thread.sleep(4000);

	}
}
