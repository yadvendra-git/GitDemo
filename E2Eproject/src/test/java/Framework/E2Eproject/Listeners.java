package Framework.E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.CommonLib;
import resources.ExtentReportersNG;

public class Listeners extends CommonLib implements ITestListener  {
	WebDriver driver=null;
	ExtentTest test;
	ExtentReports extent=ExtentReportersNG.getExtentObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal(); //If we are running test cases in parellel mode then multiple test cases will at a time will try to access onTestStart(), onTestSuccess() and onTestFailure() methods.
	//Due to that we might not get correct fail or pass results in extent reports.
	//E.g. if failed test cases accesses "test" reference variable (ExtentTest object) and that same time another test case is passing it will override value of "test" variable
	//and instead of failure, we will see pass in the test case result.
//	To overcome this issue (To make ExtentTest object threadsafe) we take help of Threadlocal class.
	//We need to repleace test reference variable with extentTest.get() (extentTest in this case) everywhere.
	//and wherever we taking object into test variable use extentTest.set(test)
	public void onTestStart(ITestResult result)
	{
		System.out.println("Starting the test");
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Successfully executing the listener code after TC pass");
		extentTest.get().log(Status.PASS, "Test case is passed");
	}

	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
	    try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//screenshot code
		System.out.println("Successfully executing the listener code after TC fail");
	String testCaseName=result.getMethod().getMethodName();
	try {
		String path=getScreenshotPath(testCaseName, driver); //This method returns the screen shot path
		extentTest.get().addScreenCaptureFromPath(path, testCaseName); 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
