package org.MobilePractice.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class DragPage {

    private final IOSDriver driver;

    public DragPage(IOSDriver driver) {
        this.driver = driver;

        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Drag");
    }


    private void dragAndDrop(WebElement piece, WebElement location) {
        Point source = getElementCenter(piece);
        Point target = getElementCenter(location);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger,1);
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),source.x, source.y));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragAndDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(),target.x,target.y));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragAndDrop));
    }

    private Point getElementCenter(WebElement element) {
        var location = element.getLocation();
        var size = element.getSize();

        return new Point(location.getX() + (size.getWidth()/2), location.getY() + (size.getHeight()/2));
    }

    private WebElement topLeftPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-l1"));
    }

    private WebElement topLeftLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-l1"));
    }

    private WebElement middleLeftPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-l2"));
    }

    private WebElement middleLeftLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-l2"));
    }

    private WebElement bottomLeftPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-l3"));
    }

    private WebElement bottomLeftLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-l3"));
    }

    private WebElement middleTopPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-c1"));
    }

    private WebElement middleTopLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-c1"));
    }

    private WebElement middlePiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-c2"));
    }

    private WebElement middleLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-c2"));
    }

    private WebElement middleBottomPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-c3"));
    }

    private WebElement middleBottomLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-c3"));
    }

    private WebElement topRightPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-r1"));
    }

    private WebElement topRightLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-r1"));
    }

    private WebElement middleRightLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-r2"));
    }

    private WebElement middleRightPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-r2"));
    }

    private WebElement bottomRightPiece() {
        return driver.findElement(AppiumBy.accessibilityId("drag-r3"));
    }

    private WebElement bottomRightLocation() {
        return driver.findElement(AppiumBy.accessibilityId("drop-r3"));
    }

    public String getCongratsMessage() {
        return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Congratulations\"`]"))
                .getText();
    }
    public void dragAndDropPieces() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Drag");


        dragAndDrop(topLeftPiece(), topLeftLocation());
        dragAndDrop(middleLeftPiece(),middleLeftLocation());
        dragAndDrop(bottomLeftPiece(),bottomLeftLocation());
        dragAndDrop(middleTopPiece(),middleTopLocation());
        dragAndDrop(middlePiece(),middleLocation());
        dragAndDrop(middleBottomPiece(),middleBottomLocation());
        dragAndDrop(topRightPiece(),topRightLocation());
        dragAndDrop(middleRightPiece(),middleRightLocation());
        dragAndDrop(bottomRightPiece(),bottomRightLocation());

    }
}
