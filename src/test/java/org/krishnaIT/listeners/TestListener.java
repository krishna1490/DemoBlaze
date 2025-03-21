package org.krishnaIT.listeners;

import com.aventstack.extentreports.Status;
import org.krishnaIT.tests.BaseTest;
import org.krishnaIT.utils.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, result.getMethod().getMethodName() + " passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " failed!");
        ExtentManager.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        captureScreenshot(result, result.getMethod().getMethodName()); // ✅ fixed
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " was skipped!");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.endTest();
    }

    // ✅ Capture screenshot with the actual test class instance
    private void captureScreenshot(ITestResult result, String testName) {
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;
            baseTest.captureScreenshot(testName);
        }
    }
}
