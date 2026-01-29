package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationLibrary implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log("test execution started" + methodName);
		 test=report.createTest(methodName);//started the execution  in rport also
		 test.log(Status.INFO, "test execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log("test execution pass" + methodName);
		 test.log(Status.PASS, methodName+"-->pass");
	}

	public void onTestFailure(ITestResult result) {
		WebdriverUtility wu = new WebdriverUtility();
		JavaUtility ju = new JavaUtility();

		String methodName = result.getMethod().getMethodName() + ju.getRandomNumber();
	//	Reporter.log("test execution fail" + methodName);
		test.log(Status.FAIL, methodName+"failed");
		try {
			String path = wu.takeScreenShot(BaseClass.Sdriver, methodName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log("test execution skip" + methodName);
		test.log(Status.SKIP, methodName+"skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		Reporter.log("test execution suite started");
		// extentsparkRepot is configure the pathe and start the execution here
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\Report- " + new JavaUtility().getSystemDateInFormat() + ".html");
		htmlReport.config().setDocumentTitle("ExtentReport for Vtiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle("Vtiger Reports Page");
		// attach the extent report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("base browser", "chrome");
		report.setSystemInfo("base Enviornment", "Testing");
		report.setSystemInfo("base platform", "windows");
		report.setSystemInfo("base url", "https://localhost:8888");
		report.setSystemInfo("Reporter name", "Aishwarya");

	}

	public void onFinish(ITestContext context) {
		Reporter.log("test execution suite finished");
		report.flush();
	}

}
