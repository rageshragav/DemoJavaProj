/**
 * 
 */
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ragesh
 *
 */
public class BaseClass {

	public static WebDriver driver;
	/**
	 * @param args
	 */

	@Test
	public void launchBrowser() {
		
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		
	}

}
	


