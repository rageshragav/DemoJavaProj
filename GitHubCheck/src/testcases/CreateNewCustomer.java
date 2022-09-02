/**
 * 
 */
package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomerPage;
import utils.XLUtils;

/**
 * @author ragesh
 *
 */
public class CreateNewCustomer extends BaseClass {

	public	NewCustomerPage newCustomerPage;
	public	LoginPage loginPage;

	@DataProvider(name="customerdata")
	String[][] getData() throws IOException{
		String path = "./resources/newcustomerdata.xlsx";
		int row = XLUtils.getRowCount(path, "Sheet1");
		int column = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String customerdata[][] = new String[row][column];
		
		for (int i = 1;i<=row;i++) {
			
			for(int j=0;j<column;j++) {
				customerdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return customerdata;
		
	}
	@BeforeClass
	public void createPOMObject() {
		
		newCustomerPage = new NewCustomerPage(driver);
		loginPage = new LoginPage(driver);
		
	}
	
	
	@Test (priority = 1)
	public void LoginPage() throws IOException {
		//System.out.println(getData());
		loginPage.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));
	}
	@Test (priority = 2,dataProvider = "customerdata")
	public void createNewCustomer(String custName,String dob,String addr,String city,String state,String pin,String telNum,String mail) throws InterruptedException  {
		
		newCustomerPage.newCustomerMenuItem.click();
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	    driver.switchTo().frame(frame1);
	    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	    driver.switchTo().frame(frame2);
	    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
	    driver.switchTo().defaultContent();
		newCustomerPage.enterCustomerName(custName);
		newCustomerPage.selectDateOfBirth(dob);
		newCustomerPage.enterAddress(addr);
		newCustomerPage.enterCity(city);
		newCustomerPage.enterState(state);
		newCustomerPage.enterpin(pin);
		newCustomerPage.enterTelephonNumber(telNum);
		newCustomerPage.enterEmail(mail);
		newCustomerPage.clickOnSubmitButton();
		Thread.sleep(4000);
		
	}
}
