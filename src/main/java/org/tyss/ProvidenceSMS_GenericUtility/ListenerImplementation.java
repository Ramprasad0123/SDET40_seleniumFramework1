package org.tyss.ProvidenceSMS_GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private	ExtentReports reports;
	private ExtentTest test;


	public void onTestStart(ITestResult result) {
		test= reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"Passed");

	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"Failed");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		String path=webDriverUtility.getScreenshot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);

	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context)
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Providence_SMS");
		spark.config().setReportName("Reorter Name: Ram");
		spark.config().setTheme(Theme.STANDARD);

		reports= new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Ram");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", "Chrome");

	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}




}
