/**
 * 
 */
package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomerPage;

/**
 * @author ragesh
 *
 */
public class CreateNewCustomer extends BaseClass {

	public	NewCustomerPage newCustomerPage;
	public	LoginPage loginPage;

	@BeforeClass
	public void createPOMObject() {
		
		newCustomerPage = new NewCustomerPage(driver);
		loginPage = new LoginPage(driver);
		
	}
	
	@Test (priority = 1)
	public void LoginPage() {
		loginPage.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));
	}
	@Test (priority = 2)
	public void createNewCustomer() throws InterruptedException  {
		
		newCustomerPage.newCustomerMenuItem.click();
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	    driver.switchTo().frame(frame1);
	    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	    driver.switchTo().frame(frame2);
	    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
	    driver.switchTo().defaultContent();
		newCustomerPage.enterCustomerName(null);
		newCustomerPage.selectDateOfBirth(null);
		newCustomerPage.enterAddress(null);
		newCustomerPage.enterCity(null);
		newCustomerPage.enterState(null);
		newCustomerPage.enterpin(0);
		newCustomerPage.enterTelephonNumber(0);
		newCustomerPage.enterEmail(null);
		//Thread.sleep(4000);
		
	}
}
