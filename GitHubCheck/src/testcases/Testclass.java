
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
import pages.NewCustomerPage;
import utils.Utility;
//import utils.object;

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
public	NewCustomerPage CustomerPg;
private int testID;

	

Testclass(){
	super();
}

	@BeforeClass
	public void createPOMObject() {
		
		loginpg = new LoginPage(driver);
        homePage = new HomePage(driver);
		CustomerPg = new NewCustomerPage(driver);
	}

	@BeforeMethod
    public void loginToApplication() throws EncryptedDocumentException, IOException, InterruptedException
    {
		
		  String data = Utility.getDataFromExcel("Sheet1","C:\\Users\\admin\\git\\DemoJavaProj\\GitHubCheck\\resources\\demobank.xlsx");
		  loginpg.sendUserName(data);
	      loginpg.sendPassward(data);
	   
	   loginpg.clickOnLogin();
	   driver.switchTo().alert().accept();
	   System.out.println("invalid credentials");
	
		
	
		
	   System.out.println("login To Application");
	   Thread.sleep(5000);
	    loginpg.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));
    }
	//@Dataprovider(name="loginDataProviderMethod")
	//public object [][] loginDataProviderMethod()
//	{
	//	return login;
	//}
   @Test
   public void toVerifyNewCustomerTab() throws EncryptedDocumentException, IOException
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
	  
	  // String customername = Utility.getCustomerDataFromExcel("Sheet1",1,0);
	 //  CustomerPg.sendCustomerName(customername);
	 //  CustomerPg.selectGender();
	 //  String DateOfBirth = Utility.getCustomerDataFromExcel("Sheet1",1,1);
	 //  CustomerPg.selectDateOfBirth(DateOfBirth);
	 //  String Address = Utility.getCustomerDataFromExcel("Sheet1",1,1);
	 //  CustomerPg.enterAddress(Address);
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

