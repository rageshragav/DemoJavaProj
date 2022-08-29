/**
 * 
 */
package testcases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class Testclass extends BaseClass {

	/**
	 * @param args
	 */
public	LoginPage loginpg;
public	HomePage homePage;
private int testID;

	

Testclass(){
	super();
}

	@BeforeClass
	public void createPOMObject() {
		
		loginpg = new LoginPage(driver);
		loginpg.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));

		homePage = new HomePage(driver);
		
	}

	@BeforeMethod
    public void loginToApplication() throws EncryptedDocumentException, IOException
    {
	    System.out.println("login To Application");
	    driver.get("http://localhost/login.do");
	    
	    String userName = Utility.getDataFromExcel("demoBank",1,0);
	    loginpg.sendUserName(userName);
	    
	    String Passward = Utility.getDataFromExcel("demoBank",1,1);
	    loginpg.sendPassward(Passward);
	    loginpg.clickOnLogin();
	 
   }
   @Test
   public void toVerifyNewCustomerTab()
   {
	  testID = 101;
	  SoftAssert softAssert = new SoftAssert();
	  System.out.println("to Verify NewCustomer Tab/Button");
	  homePage.openNewCustomerpage();
	  String url = driver.getCurrentUrl();
	  String title = driver.getTitle();
	  softAssert.assertEquals(url, "");
	  softAssert.assertEquals(title,"");
	  softAssert.assertAll();
   }
   @AfterMethod
   public void logoutFromApplication(ITestResult result) throws IOException
   {
	   if(ITestResult.FAILURE == result.getStatus())
	   {
		   Utility.getScreenshot(driver, testID);
	   }
	    System.out.println("logout From Application");
	    homePage.clickOnlogout();
   }
   @AfterClass
   public void clearPOMObject()
   {
	   loginpg = null;
	   homePage = null;
   }
   @AfterTest
   public void closedBrowser()
   {
	    System.out.println("closedBrowser");
	    driver.quit();
	    driver = null;
	    System.gc();//to delete the object
   }
}

