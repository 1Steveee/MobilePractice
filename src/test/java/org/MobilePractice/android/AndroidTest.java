package org.MobilePractice.android;

import io.appium.java_client.android.AndroidDriver;
import org.MobilePractice.android.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AndroidTest extends BaseTest {


    private AndroidDriver driver;
    private final String email = "randomemail@gmail.com";
    private final String password = "password123";
//    private SwipePage swipePage;

    @BeforeClass
    public void setUpTest() {
        this.driver = androidDriverManager.getDriver();
    }

    @Test
    public void testHomePageTitle() {
        HomePage homePage = new HomePage(this.driver);
        assertEquals(homePage.getTitle (), "WEBDRIVER");
    }

    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(this.driver);
        signUpPage.SignUp(email, password);
        assertEquals(signUpPage.getSuccessMessageTitle(), "Signed Up!");
        assertEquals(signUpPage.getSuccessMessage(),"You successfully signed up!");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(email,password);
        assertEquals(loginPage.getSuccessMessageTitle(),"Success");
        assertEquals(loginPage.getSuccessMessage(), "You are logged in!");
    }

    @Test
    public void testSwipeLeft() {
        SwipePage swipePage = new SwipePage(this.driver);
        swipePage.swipeLeft();
        assertEquals(swipePage.getCardTwoDescriptionText(), "WebdriverIO has a great community that supports all members.");
    }

    @Test
    public void testSwipeUp() {
        SwipePage swipePage = new SwipePage(this.driver);

        assertEquals(swipePage.swipeUpToFindElement(), "You found me!!!");
    }

    @Test
    public void testDragAndDrop() {

        DragDropPage dragDropPage = new DragDropPage(this.driver);
        dragDropPage.dragAndDropPieces();
        assertEquals(dragDropPage.getSuccessMessageText(), "You made it, click retry if you want to try it again.");
    }

    @Test
    public void testCompleteForm() {
        String inputText = "helloword123";
        String dropdownText = "webdriver.io is awesome";
        FormsPage formsPage = new FormsPage(this.driver);
        formsPage.completeForm(inputText, dropdownText);

        assertEquals(formsPage.getActiveButtonMessage(), "This button is active");
        assertEquals(formsPage.getInputTextResultText(), inputText);
        assertEquals(formsPage.getSwitchTextElement(), "Click to turn the switch OFF");
        assertEquals(formsPage.getDropdownText(), dropdownText);


    }
}
