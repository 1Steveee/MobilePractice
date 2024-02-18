package org.MobilePractice.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final IOSDriver driver;

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Login");
    }

    private WebElement loginTab() {
        return driver.findElement(AppiumBy
                .accessibilityId("button-login-container"));
    }

    private WebElement emailField() {
        return driver.findElement(AppiumBy.accessibilityId("input-email"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("input-password"));
    }

    private WebElement successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = driver.findElement(AppiumBy.accessibilityId("You are logged in!"));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement successMessageCloseButton() {
        return driver.findElement(AppiumBy.accessibilityId("OK"));
    }

    private void clickSuccessCloseButton() {
        successMessageCloseButton().click();
    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }

    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-LOGIN"));
    }


    public void Login(String email, String password) {
        loginTab().click();
        emailField().clear();
        emailField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginButton().click();
    }


    public void closeSuccessMessage() {
        clickSuccessCloseButton();
        driver.hideKeyboard();

        if (successMessageCloseButton().isEnabled()) {
            clickSuccessCloseButton();
        }
    }
}
