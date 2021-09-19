package utilities.Listener;
import com.aventstack.extentreports.Status;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseTest;
import testBase.DriverFactory;
import utilities.ExtentReports.*;


public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
            ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
