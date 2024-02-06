package org.MobilePractice.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormsPage {
    private final IOSDriver driver;

    public FormsPage(IOSDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Forms");
    }

    private WebElement textInputField() {
        return driver.findElement(AppiumBy.accessibilityId("text-input"));
    }

    private WebElement switchButton() {
        return driver.findElement(AppiumBy.accessibilityId("switch"));
    }

    private List<WebElement> dropdownList() {
        return driver.findElements(AppiumBy.className("XCUIElementTypePickerWheel"));
    }

    private WebElement dropdownMenu() {

        return driver.findElement(AppiumBy.accessibilityId("Dropdown"));
    }

    private WebElement findElement(String accessibilityID) {
        return driver.findElement(AppiumBy.accessibilityId(accessibilityID));
    }


    private WebElement activeButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-Active"));
    }

    private WebElement alertMessage() {
        return driver.findElement(AppiumBy.id("This button is active"));
    }


    public WebElement okButton () {
        return driver.findElement(AppiumBy.id("OK"));
    }


    private WebElement doneButton() {
        return driver.findElement(AppiumBy.accessibilityId("done_button"));
    }

    public void fillForm(String inputField, String dropdownValue)  {
        textInputField().sendKeys(inputField);
        switchButton().click();
        selectDropdownValue(dropdownValue);
        doneButton().click();
    }

    private void selectDropdownValue(String dropdownValue) {
        dropdownMenu().click();
        dropDownItem().sendKeys(dropdownValue);
    }

    private WebElement dropDownItem() {
//        return driver.findElement(AppiumBy
//                .iOSClassChain
//                        ("**/XCUIElementTypePickerWheel[`value == \"Select an item...\"`]"));

        return driver.findElement(AppiumBy.className("XCUIElementTypePickerWheel"));
    }

    private WebElement dropDownElement() {
        return driver.findElement(AppiumBy.accessibilityId("text_input"));
    }

    public String getDropdownText() {
        return dropDownElement().getAttribute("value");
    }
    public String getInputFieldText() {
        return findElement("input-text-result").getText();
    }

    public String getSwitchFieldText() {
        return findElement("switch-text").getText();
    }

    public String getAlertMessageText() {
        return alertMessage().getText();
    }


    public void submitForm() {
        activeButton().click();
    }

    public void closeAlert() {
        okButton().click();
    }
}
