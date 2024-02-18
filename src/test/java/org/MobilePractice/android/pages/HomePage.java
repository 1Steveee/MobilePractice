package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

    private final AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {

        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiSelector().text(\"WEBDRIVER\")")).getText();
    }

    public void openMenu(String menu) {
        driver.findElement(AppiumBy.accessibilityId(menu)).click();
    }
}
