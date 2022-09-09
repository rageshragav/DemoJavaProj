/**
 * 
 */
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author ragesh
 *
 */
public class Reporting 
{
	public static ExtentTest extentTest;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	
	 public static ExtentReports getReportObject() {
		 
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("Extentreport.html");
		extent.attachReporter(spark);
		spark.config().setReportName("Amzon web test results");
		spark.config().setDocumentTitle("Test results");
		extent.setSystemInfo("Ragesh", "Technical engineer");
		return extent;
	 }
}
