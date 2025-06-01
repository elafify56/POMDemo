package com.automationexercise.listeners;

import com.automationexercise.factory.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenshotManager;

import java.io.IOException;

public class TestNGListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = ExtentManager.createTest(testName);
        result.setAttribute("reportTest",test);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTest test = (ExtentTest) result.getAttribute("reportTest");
        test.pass("✅ Test Case passed Successfully!!");
    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentTest test = (ExtentTest) result.getAttribute("reportTest");
        test.fail("❌ TestCase Failed: "+ result.getThrowable());

        String screenshotPath =ScreenshotManager.takeScreenShot(DriverFactory.getDriver(),result.getMethod().getMethodName());
        if (screenshotPath!=null){
            test.addScreenCaptureFromPath(screenshotPath);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentTest test = (ExtentTest) result.getAttribute("reportTest");
        test.skip("Test Case Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context){
        try {
            ExtentManager.flushReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
