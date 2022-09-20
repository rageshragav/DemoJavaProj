/**
 * 
 */
package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ragesh
 *
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties properties;
	public static ExtentTest extentTest;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;


	/**
	 * @param args
	 */

	@BeforeTest
	public void launchBrowser() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Extentreport.html");
		extent.attachReporter(spark);
		spark.config().setReportName("Amzon web test results");
		spark.config().setDocumentTitle("Test results");
		extent.setSystemInfo("Ragesh", "Technical engineer");
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public BaseClass() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("./config.properties/");
			//FileInputStream ip = new FileInputStream("C:\\Users\\admin\\git\\DemoJavaProj\\GitHubCheck\\config.properties");
			properties.load(ip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void flushExtent() {
		driver.quit();
		extent.flush();
	}
}
