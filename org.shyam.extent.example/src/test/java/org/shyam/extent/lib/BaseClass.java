package org.shyam.extent.lib;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

    protected void logMessage(LogStatus status, String message) {
        if (status == LogStatus.SKIP) {
            throw new SkipException(message);
        }
        else {
            ExtentTestManager.getTest().log(status, message);
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        ExtentTestManager.startTest(method.getName());
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test " + result.getName() + " failed ");
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test " + result.getName() + " skipped");
        }
        else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test " + result.getName() + " passed");
        }

        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
    }

    /*protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }*/
}
