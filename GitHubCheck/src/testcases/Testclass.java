
/**
 * 
 */
package testcases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
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
        homePage = new HomePage(driver);
		
	}

	@BeforeMethod
    public void loginToApplication() throws EncryptedDocumentException, IOException, InterruptedException
    {
		
	    for(int row=0;row<4;row++) {
	    	 for(int cell=0;cell<row;cell++) {	
	   String userName = Utility.getDataFromExcel("Sheet1",row,cell);
	   loginpg.sendUserName(userName);
	    
	    String Password = Utility.getDataFromExcel("Sheet1",row,cell);
	   loginpg.sendPassward(Password);
	   loginpg.clickOnLogin();
	   driver.switchTo().alert().accept();
	   System.out.println("invalid credentials");
	    }
	    }
	   System.out.println("login To Application");
	   Thread.sleep(5000);
	    loginpg.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));
   }
   @Test
   public void toVerifyNewCustomerTab()
   {
	  testID = 101;
	  SoftAssert softAssert = new SoftAssert();
	  System.out.println("to Verify NewCustomer Tab/Button");
	  homePage.opennewCustomerPage();
	  String url = driver.getCurrentUrl();
	  String title = driver.getTitle();
	  softAssert.assertEquals(url, "https://demo.guru99.com/V1/html/addcustomerpage.php");
	  softAssert.assertEquals(title," Gtpl Bank New Customer Entry Page ");
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
	    homePage.clickOnlogOutTab();
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
	//    driver.quit();
	   // driver = null;
	    //System.gc();//to delete the object
   }
}

