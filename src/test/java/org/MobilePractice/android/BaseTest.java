package org.MobilePractice.android;

import org.MobilePractice.AndroidDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriverManager androidDriverManager;

    @Parameters("deviceId")
    @BeforeClass(alwaysRun = true)
    public void testSetup (String deviceId) throws MalformedURLException {
        androidDriverManager = new AndroidDriverManager(deviceId);
        androidDriverManager.createAndroidDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        androidDriverManager.stopDriver();
    }
}
