package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private final AppiumDriver driver;

    public SignUpPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement Login() {
        return driver.findElement(AppiumBy.accessibilityId("Login"));
    }

    private WebElement emailField() {
        return driver.findElement(AppiumBy.accessibilityId("input-email"));
    }

    private WebElement signUpTab() {
        return driver.findElement(AppiumBy.accessibilityId("button-sign-up-container"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("input-password"));
    }

    private WebElement confirmPasswordField() {
        return driver.findElement(AppiumBy.accessibilityId("input-repeat-password"));
    }

    private WebElement signUpButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-SIGN UP"));
    }

    private WebElement successMessageTitle() {
        return driver.findElement(AppiumBy.id("android:id/alertTitle"));
    }

    private WebElement successMessage() {
        return driver.findElement(AppiumBy.id("android:id/message"));
    }

    private WebElement okButton() {
        return driver.findElement(AppiumBy.id("android:id/button1"));
    }

    private void navigateToSignUpPage() {
        Login().click();
        signUpTab().click();
    }
    public void SignUp(String email, String password) {
        navigateToSignUpPage();
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        confirmPasswordField().sendKeys(password);
        signUpButton().click();
    }

    public String getSuccessMessageTitle() {
        return successMessageTitle().getText();
    }

    public String getSuccessMessage() {
        String message = successMessage().getText();
        okButton().click();
        return message;
    }

}
