package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {

    private final AndroidDriver driver;

    public FormsPage(AndroidDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Forms");
    }

    private WebElement switchButton() {
        return driver.findElement(AppiumBy.accessibilityId("switch"));
    }

    private WebElement dropDownButton() {
        return driver.findElement(AppiumBy.accessibilityId("Dropdown"));
    }

    private WebElement inputField() {
        return driver.findElement(AppiumBy.accessibilityId("text-input"));
    }

    private WebElement activeButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-Active"));
    }

    private WebElement activeButtonMessage() {
        return driver.findElement(AppiumBy.id("android:id/message"));
    }

    private WebElement okButton() {
        return driver.findElement(AppiumBy.id("android:id/button1"));
    }
    private WebElement findDropdownText(String text) {
        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiSelector().text(\"" + text  + "\")"));
    }

    private WebElement switchTextElement() {
        return driver.findElement(AppiumBy.accessibilityId("switch-text"));
    }

    private WebElement inputTextResult() {
        return driver.findElement(AppiumBy.accessibilityId("input-text-result"));
    }

    private WebElement dropdownText() {
        return driver.findElements(AppiumBy.className("android.widget.EditText")).get(1);
    }

    public String getDropdownText() {
        return dropdownText().getText();
    }
    public void completeForm(String inputText, String dropdownText) {
        inputField().sendKeys(inputText);
        switchButton().click();
        dropDownButton().click();
        findDropdownText(dropdownText).click();
        activeButton().click();
    }

    public String getActiveButtonMessage() {
        String message = activeButtonMessage().getText();
        okButton().click();
        return message;
    }

    public String getInputTextResultText() {
        return inputTextResult().getText();
    }

    public String getSwitchTextElement() {
        return switchTextElement().getText();
    }
}
