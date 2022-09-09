/**
 * 
 */
package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author ragesh
 *
 */
public class Listners implements ITestListener{

	ExtentTest test;
	ExtentReports extent = Reporting.getReportObject();
	// When Test case get Started, this method is called.		
	@Override		
    public void onTestStart(ITestResult Result)					
    {		
    test =	extent.createTest(Result.getMethod().getMethodName());
    }	
	
	// When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    test.log(Status.PASS, "Test Passed");
    }	
	@Override		
    public void onTestFailure(ITestResult Result) 					
    {		
		test.fail(Result.getThrowable());
		
		
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    test.log(Status.SKIP, "Test Skipped");
    }		

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
    }

    	

	
}
