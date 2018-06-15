package testngWorks;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener{

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite arg0) {
		Reporter.log("Suite ended: " +arg0.getName(), true);
		
	}

	public void onStart(ISuite arg0) {
		Reporter.log("Suite about to be run: " +arg0.getName(), true);
		
	}

	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing Tests" +arg0.getName(), true);
		
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("About to start executing test..." +arg0.getName(), true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test failed: " +arg0.getName(), true);
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test started: " +arg0.getName(), true);
		
	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Test passed: " +arg0.getName(), true);
		
	}

}
