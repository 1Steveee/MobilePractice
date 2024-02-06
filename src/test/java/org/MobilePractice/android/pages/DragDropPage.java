package org.MobilePractice.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class DragDropPage {

    private final AndroidDriver driver;
    public DragDropPage(AndroidDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Drag");
    }

    private WebElement successMessage() {
        return driver.findElement(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"You made it, click retry if you want to try it again.\")"));
    }

    private void dragPiece(WebElement piece, WebElement location) {
        Point pieceLocation = getLocation(piece);
        Point targetLocation = getLocation(location);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger,1);
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),pieceLocation.x, pieceLocation.y));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragAndDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(),targetLocation.x,targetLocation.y));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(dragAndDrop));
    }

    private Point getLocation(WebElement element) {
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

    public void dragAndDropPieces() {
        dragPiece(topLeftPiece(), topLeftLocation());
        dragPiece(middleTopPiece(), middleTopLocation());
        dragPiece(topRightPiece(), topRightLocation());
        dragPiece(middleLeftPiece(), middleLeftLocation());
        dragPiece(middlePiece(), middleLocation());
        dragPiece(middleRightPiece(), middleRightLocation());
        dragPiece(bottomLeftPiece(), bottomLeftLocation());
        dragPiece(middleBottomPiece(), middleBottomLocation());
        dragPiece(bottomRightPiece(), bottomRightLocation());
    }

    public String getSuccessMessageText() {
        return successMessage().getText();
    }


}
