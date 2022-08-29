/**
 * 
 */
package testcases;

import java.util.Properties;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

/**
 * @author ragesh
 *
 */
public class Testclass extends BaseClass {

	/**
	 * @param args
	 */
public	LoginPage loginpg;

	

Testclass(){
	super();
}

	@Test
	public void login() {
		
		loginpg = new LoginPage(driver);
		loginpg.loginToDemoBank(properties.getProperty("user"), properties.getProperty("password"));
		
	}


}
	


