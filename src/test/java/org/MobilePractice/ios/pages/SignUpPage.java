package org.MobilePractice.ios.pages;

import com.sun.net.httpserver.Authenticator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private final IOSDriver driver;

    public SignUpPage(IOSDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Login");
    }
    private WebElement emailField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-email"));
    }

    private WebElement signUpLink () {
        return driver.findElement (AppiumBy.accessibilityId ("button-sign-up-container"));
    }

    private WebElement passwordField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-password"));
    }

    private WebElement confirmPasswordField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-repeat-password"));
    }

    private WebElement signUpBtn () {
        return driver.findElement (AppiumBy.accessibilityId ("button-SIGN UP"));
    }

    private WebElement okSuccessMessageButton() {
        return driver.findElement(AppiumBy.accessibilityId("OK"));
    }
    private void dismissSuccessMessage() {
        okSuccessMessageButton().click();
    }

    public void signUp(String email, String password) {
        signUpLink().click();
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        confirmPasswordField().sendKeys(password);
        signUpBtn().click();
    }


    public String getSuccessMessage () {
        WebElement successMessage = driver.findElement (AppiumBy.accessibilityId ("You successfully signed up!"));
        String successMessageText = successMessage.getText ();
        driver.hideKeyboard();
        dismissSuccessMessage();
        return successMessageText;
    }

    public String getSuccessMessageTitle () {

        return driver.findElement(AppiumBy
                .iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Signed Up!\"`]")).getText();


    }
}
