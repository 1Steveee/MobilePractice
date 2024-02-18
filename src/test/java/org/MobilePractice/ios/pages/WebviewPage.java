package org.MobilePractice.ios.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebviewPage {

    private final IOSDriver driver;
    public WebviewPage(IOSDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Webview");
    }

    public void switchToWebView() {
        // Switching to webview
        Set<String> contextNames = driver.getContextHandles();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until((d) -> contextNames.size() >= 1);
        System.out.println((String)contextNames.toArray()[1]);
//        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_<APP_PKG_NAME>
    }


}
