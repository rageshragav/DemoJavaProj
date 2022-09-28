/**
 * 
 */
package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Log;
import utils.Utility;

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
	public String className = this.getClass().getSimpleName();
	public static String currentTestName;

	/**
	 * @param args
	 */

	@BeforeTest
	public void launchBrowser() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Extentreport.html");
		spark.config().setEncoding("utf-8");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Amzon web test results");
		spark.config().setDocumentTitle("Test results");
		extent.setSystemInfo("Ragesh", "Technical engineer");
		driver = WebDriverManager.chromedriver().create();
		Log.info("Browser launched", className);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		Log.info(properties.getProperty("url") + " Loaded", className);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		currentTestName = method.getName();

	}

	public BaseClass() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("./config.properties/");
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
		String Foldername = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss").format(new Date());
		File src_Report = new File("./Extentreport.html/");
		File move_Report = new File("D:/AmazonExtent/" + className + Foldername + ".html");
		try {
			FileUtils.copyFile(src_Report, move_Report);
			Log.error("Moved the master report to the destination folder", className);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.error("Error while moving the master report to the destination folder" + e, className);

		}
	}
}
