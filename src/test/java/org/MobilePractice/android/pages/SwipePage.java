package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class SwipePage {

    private final AndroidDriver driver;

    public SwipePage(AndroidDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Swipe");
    }

    private WebElement cardTwoDescription() {
        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiSelector().text(\"WebdriverIO has a great community that supports all members.\")"));
    }

    private WebElement youFoundMeText() {
        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiSelector().text(\"You found me!!!\")"));
    }

    public void swipeLeft() {
        WebElement sourceElement = driver
                .findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]"));


        int startX = sourceElement.getLocation().getX() + sourceElement.getSize().getWidth();
        int startY = sourceElement.getLocation().getY() + sourceElement.getSize().getHeight() / 2;

        int endX = sourceElement.getLocation().getX();
        int endY = sourceElement.getLocation().getY();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(600)));

        driver.perform(List.of(swipe));
    }

    public void swipeUp() {
        Dimension screenSize = driver.manage().window().getSize();

        Point startPoint = new Point((screenSize.width / 2), (int) (screenSize.height * 0.9));
        Point endPoint = new Point((screenSize.width / 2),(int) (screenSize.height * 0.2));

        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(pointerInput, 1);


        swipe.addAction(pointerInput
                .createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),startPoint.x,startPoint.y));
        swipe.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(pointerInput
                .createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),endPoint.x,endPoint.y));
        swipe.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    public String swipeUpToFindElement() {
//        driver.findElement(AppiumBy.androidUIAutomator
//                ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"You found me!!!\"));"));

        final WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()" +
                        ".scrollable(true)).scrollIntoView(new UiSelector().text(\"You found me!!!\"))"));
        return targetElement.getText();
    }

    public String getCardTwoDescriptionText() {
        return  cardTwoDescription().getText();
    }

    public String getYouFoundMeText() {
        return youFoundMeText().getText();
    }
}
