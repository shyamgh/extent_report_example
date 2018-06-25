package org.shyam.extent.tests;

import org.shyam.extent.lib.BaseClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class QATEST_1000_1002 extends BaseClass {

    @Test
    public void QATEST__1000() throws Exception {
        logMessage(LogStatus.FAIL, "Log from threadId: " + Thread.currentThread().getId());
        logMessage(LogStatus.PASS, "Log from threadId: " + Thread.currentThread().getId());

        throw new Exception("intentional failure");
    }

    @Test
    public void QATEST__1002() throws Exception {
        logMessage(LogStatus.INFO, "Steps 1: " + Thread.currentThread().getId());
        logMessage(LogStatus.SKIP, "Steps 2: " + Thread.currentThread().getId());
    }
}
