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

import base.BaseClass;

/**
 * @author ragesh
 *
 */
public class Listners extends BaseClass implements ITestListener{

	ExtentTest test;
	ExtentReports extent = Reporting.getReportObject();
	
	@Override		
    public void onTestStart(ITestResult Result)					
    {		
    test =	extent.createTest(Result.getMethod().getMethodName());
    }	
	
			
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    test.log(Status.PASS, "Test Passed",Utility.captureScreenShot(driver));
    
    }	
	@Override		
    public void onTestFailure(ITestResult Result) 					
    {		
		test.fail(Result.getThrowable());
    }		

  
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    test.log(Status.SKIP, "Test Skipped");
    }		

    @Override
    public void onFinish(ITestContext context) {
    	driver.quit();
    	extent.flush();
    }

    	

	
}
