package com.Listeners;

import org.apache.xmlbeans.impl.soap.Detail;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.base.BaseClass;

public class ListenerEx extends BaseClass  implements ITestListener {

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
    }
	public void onTestSuccess(ITestResult result) {
		test.log(test.getStatus().PASS,"Test case passed with name"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(test.getStatus().FAIL,"Test case failed with name"+result.getName());
		test.log(test.getStatus().FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(getscreenshot(result.getName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(test.getStatus().SKIP,"Test case skip with name"+result.getName());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
