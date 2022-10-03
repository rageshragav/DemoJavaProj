/**
 * 
 */
package testdataprovider;

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
public class TestDataProvider {

	@DataProvider(name = "vehicledata")
	public static String[][] getData() throws IOException {
		String path = "./resources/vehicledetails.xlsx";
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

}
