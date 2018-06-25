package org.shyam.extent.tests;

import org.shyam.extent.lib.BaseClass;
import org.shyam.extent.lib.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class QATEST_1001 extends BaseClass {

    @Test
    public void QATEST__1001() {
        logMessage(LogStatus.PASS, "Steps 1: " + Thread.currentThread().getId());
        logMessage(LogStatus.INFO, "Steps 2: " + Thread.currentThread().getId());

        Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(), LogStatus.PASS);
    }
}
