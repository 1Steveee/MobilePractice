package org.MobilePractice.ios;

import org.MobilePractice.IOSDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    protected IOSDriverManager iosDriverManager;

    @Parameters("deviceId")
    @BeforeClass(alwaysRun = true)
    public void testSetUp(String deviceId) throws  MalformedURLException {
        iosDriverManager = new IOSDriverManager(deviceId);
        iosDriverManager.createIOSDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        iosDriverManager.stopDriver();
    }
}
