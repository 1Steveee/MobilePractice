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


}
