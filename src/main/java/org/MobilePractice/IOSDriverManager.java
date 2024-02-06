package org.MobilePractice;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSDriverManager {

    private IOSDriver driver;
    private final String APP_PATH = System.getProperty ("user.home") + "/Downloads/wdiodemoapp.app";

    private XCUITestOptions xcuiTestOptions() {
        return new XCUITestOptions()
                .setPlatformName("iOS")
                .setPlatformVersion("17.2")
                .setDeviceName("iPhone 15 Pro")
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setApp(APP_PATH)
                .setNoReset(false);
    }

    public void createIOSDriver() throws MalformedURLException {
        final String APPIUM_SERVER_URL = "http://localhost:4723/";
        driver = new IOSDriver(new URL(APPIUM_SERVER_URL), xcuiTestOptions());
        setUpDriverTimeOuts();
    }

    private void setUpDriverTimeOuts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void stopDriver() {
        driver.quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }
}
