package org.MobilePractice.ios;

import io.appium.java_client.ios.IOSDriver;
import org.MobilePractice.ios.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class IOSTest extends BaseTest {

    private IOSDriver driver;

    @BeforeClass
    public void setUpTest() {
        this.driver = iosDriverManager.getDriver();
    }

    @Test
    public void testHomePageTitle() {
        HomePage homePage = new HomePage (this.driver);
        assertEquals (homePage.getTitle (), "WEBDRIVER");
        System.out.println(homePage.getTitle());
    }

    @Test
    public void testSignUp() {
        //        Use Data Faker
//  Save global Variable
        SignUpPage signUpPage = new SignUpPage(this.driver);
        signUpPage.signUp("steven7777@gmail.com", "Test12345");
        assertEquals (signUpPage.getSuccessMessageTitle (), "Signed Up!");
        assertEquals (signUpPage.getSuccessMessage (), "You successfully signed up!");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.Login("steven123@gmail.com", "Test12345");
        assertEquals(loginPage.getSuccessMessage(), "You are logged in!");
        loginPage.closeSuccessMessage();
    }

    @Test
    public void testFormSignUp() {
        FormsPage formsPage = new FormsPage(this.driver);
        formsPage.fillForm("text1234", "This app is awesome");
        assertEquals("text1234",formsPage.getInputFieldText());
        assertEquals("Click to turn the switch OFF", formsPage.getSwitchFieldText());
        assertEquals("This app is awesome", formsPage.getDropdownText());
        formsPage.submitForm();
        assertEquals("This button is active", formsPage.getAlertMessageText());
        formsPage.closeAlert();
    }

    @Test
    public void testDragAndDrop() {
        DragPage dragPage = new DragPage(driver);
        dragPage.dragAndDropPieces();
        assertEquals("Congratulations", dragPage.getCongratsMessage());
    }



}
