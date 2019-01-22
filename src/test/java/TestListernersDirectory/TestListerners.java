package TestListernersDirectory;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListerners implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("***********  Test Started :"+ iTestResult.getName());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("***********  Test OnSuccess :"+ iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("***********  Test Onfailure :"+ iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("***********  Test On Skipp :"+ iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("***********  Test Finished :"+ iTestContext.getName());
    }
}
