package core;

import bot.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected WebDriver driver;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Base.restoreUserBase();
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("TEST Success");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Base.saveUsers();
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("TEST FAILED");
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        Base.restoreUserBase();
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        Base.saveUsers();
    }
}
