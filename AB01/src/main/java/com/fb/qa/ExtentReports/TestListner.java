package com.fb.qa.ExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fb.qa.base.TestBase;

public class TestListner extends TestBase implements ITestListener{
	
	//Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();	
    
    public void  createInstance() {
       /* platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);*/
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport"+System.currentTimeMillis()+".html");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("facebook");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("facebook repoitr");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        //extent;
    }
 
   // @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
 
    //@Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
 
    //@Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }
 
   // @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        extent.flush();
    }
 
   // @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        extent.flush();
    }
 
    //@Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
        extent.flush();
    }
 
    //@Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
        extent.flush();
    }

}
