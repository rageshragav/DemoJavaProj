/**
 * 
 */
package testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAddressPage;
import utils.XLUtils;

/**
 * @author ragesh
 *
 */
public class LoginScenarios extends BaseClass{

	public	LoginPage loginpg;
	public	HomePage homePage;
	public	NewAddressPage CustomerPg;
	
	@DataProvider(name="logindata")
	String[][] getData() throws IOException{
		String path = "./resources/diffUsers.xlsx";
		int row = XLUtils.getRowCount(path, "Sheet1");
		int column = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[row][column];
		
		for (int i = 1;i<=row;i++) {
			
			for(int j=0;j<column;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		
		loginpg = new LoginPage(driver);
        homePage = new HomePage(driver);
		CustomerPg = new NewAddressPage(driver);
	}
	
	@Test(dataProvider = "logindata")
	public void loginScenarios(String userName,String passWord) {
		
		loginpg.loginToAmazon(userName,passWord);
		//loginpg.sendUserName(userName);
	    //loginpg.sendPassward(passWord);
	    //loginpg.clickOnLogin();
	
	    /*
	   if(isAlertPresent()==true) {
		   driver.switchTo().alert().accept();
		   driver.switchTo().defaultContent();
		   Assert.assertTrue(false);
	   }else {
		   Assert.assertTrue(true);
		   loginpg.clickOnLogout();
		   driver.switchTo().alert().accept();
		   driver.switchTo().defaultContent();
	}*/
	   
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
	}
}
