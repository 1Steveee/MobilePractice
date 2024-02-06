package org.MobilePractice.android;

import org.MobilePractice.AndroidDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriverManager androidDriverManager;

    @BeforeClass(alwaysRun = true)
    public void testSetup () throws MalformedURLException {
        androidDriverManager = new AndroidDriverManager();
        androidDriverManager.createAndroidDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        androidDriverManager.stopDriver();
    }
}
