package org.MobilePractice.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class SwipePage {

    private final IOSDriver driver;

    public SwipePage(IOSDriver driver){
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Swipe");
    }

    private WebElement scrollableItemMenu() {
        return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"card\"])[1]"));
    }

    public void swipeVertical() {

        var screenSize = driver.manage().window().getSize();
        var centerY = (int)screenSize.getHeight() / 2;
        var centerX = (int)screenSize.getWidth() / 2;
        Point center = new Point(centerX, centerY);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger,1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),center.x,center.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin
                .viewport(),center.x, (int) (center.y - (center.y * 80 / 100))));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(1000)));
        driver.perform(List.of(swipe));
    }


    public void swipeHorizontal() {
        Point sourceLocation = scrollableItemMenu().getLocation();
        System.out.println(sourceLocation.x);
        System.out.println(sourceLocation.y);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),
                (int) (sourceLocation.x * 6), sourceLocation.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),
                (int) (sourceLocation.x *.8), sourceLocation.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(1000)));
        driver.perform(List.of(swipe));


    }
}
