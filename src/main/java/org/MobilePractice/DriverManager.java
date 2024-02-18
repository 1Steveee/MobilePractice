package org.MobilePractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.ofSeconds;

public class DriverManager {
    private AppiumDriver appiumDriver;
    private final String APP_PATH = System.getProperty ("user.home") + "//Downloads//android.wdio.native.app.v1.0.8.apk";

    private void getDesiredCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        try (FileInputStream fis = new FileInputStream("src/test/resources/mobileConfig.json")) {
            final var objectMapper = new ObjectMapper();
            final JsonNode jsonNode = objectMapper.readValue(fis, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

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

    public void createDriver() throws MalformedURLException {
        appiumDriver = new AppiumDriver (new URL("http://localhost:4723/"),uiAutomator2Options ());
        setupDriverTimeouts();
    }

    public void stopDriver() {
        appiumDriver.quit();
    }

    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    private void setupDriverTimeouts () {
        appiumDriver.manage ()
                .timeouts ()
                .implicitlyWait (ofSeconds (30));
    }
}
