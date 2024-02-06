package org.MobilePractice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.*;

public class AndroidDriverManager {

    private AndroidDriver androidDriver;
    private final String APP_PATH = System.getProperty ("user.home") + "//Downloads//android.wdio.native.app.v1.0.8.apk";


    private UiAutomator2Options uiAutomator2Options () {

        UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options ()
                .setDeviceName ("Pixel_6_API_34")
                .setAutomationName (AutomationName.ANDROID_UIAUTOMATOR2)
                .setAvdLaunchTimeout (ofSeconds (300))
                .setAvdReadyTimeout (ofSeconds (100))
                .setApp (APP_PATH)
                .setAppPackage ("com.wdiodemoapp")
                .setAppActivity ("com.wdiodemoapp.MainActivity")
                .setNoReset (false)
                .setPlatformName("Android");
        return uiAutomator2Options;
    }

    public void createAndroidDriver () throws MalformedURLException {
        androidDriver = new AndroidDriver (new URL("http://localhost:4723/"),uiAutomator2Options ());
        setupDriverTimeouts();
    }

    public void stopDriver() {
        androidDriver.quit();
    }

    public AndroidDriver getDriver() {
        return androidDriver;
    }

    private void setupDriverTimeouts () {
        androidDriver.manage ()
                .timeouts ()
                .implicitlyWait (ofSeconds (30));
    }
}
