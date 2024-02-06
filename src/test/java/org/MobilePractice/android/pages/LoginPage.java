package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement loginTab() {
        return driver.findElement(AppiumBy.accessibilityId("button-login-container"));
    }

    private WebElement emailField() {
        return driver.findElement(AppiumBy.accessibilityId("input-email"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("input-password"));
    }

    private WebElement successMessageTitle() {
        return driver.findElement(AppiumBy.id("android:id/alertTitle"));
    }

    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-LOGIN"));
    }

    private WebElement successMessage() {
        return driver.findElement(AppiumBy.id("android:id/message"));
    }
    private WebElement successMessageCloseButton() {
        return driver.findElement(AppiumBy.id("android:id/button1"));
    }

    private void navigateToLoginTab() {
        loginTab().click();
    }

    public void login(String email, String password) {
        navigateToLoginTab();
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginButton().click();
    }

    public String getSuccessMessageTitle() {
        return successMessageTitle().getText();
    }

    public String getSuccessMessage() {
        String message = successMessage().getText();
        successMessageCloseButton().click();
        return message;
    }

}
