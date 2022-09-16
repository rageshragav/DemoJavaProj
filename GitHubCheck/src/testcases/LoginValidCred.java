/**
 * 
 */
package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAddressPage;

/**
 * @author ragesh
 *
 */
public class LoginValidCred extends BaseClass{

	public	LoginPage loginpg;
	public	HomePage homePage;
	public	NewAddressPage CustomerPg;
	
	@BeforeClass
	public void createPOMObject() {
		
		loginpg = new LoginPage(driver);
        homePage = new HomePage(driver);
		CustomerPg = new NewAddressPage(driver);
	}
	
	
	@Test
	public void loginWithValidCredentails() {
		extentTest = extent.createTest("Valid login test");
		loginpg.loginToAmazon(properties.getProperty("user"), properties.getProperty("password"));
		extentTest.log(Status.PASS, "login successfull");
		extentTest.pass("user login successfull");
		
	}
}
