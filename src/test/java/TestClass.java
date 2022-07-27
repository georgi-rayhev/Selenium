import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenium.models.User;
import selenium.pages.*;
import selenium.utils.Browser;

import java.net.MalformedURLException;

public class TestClass {

    RegistrationLoginPage registrationLoginPage = new RegistrationLoginPage();
    HomePage homePage = new HomePage();


    @BeforeEach
    public void startBrowser() throws MalformedURLException {
        Browser.openBrowser();
    }

    @AfterEach
    public void closeBrowser() {
        Browser.closeBrowser();
    }

//    @Test
//    public void userRegistration() throws MalformedURLException {
//        User newUser = registrationLoginPage.buildUser();
//        System.out.println(newUser);
//        homePage.goToHomePage();
//        registrationLoginPage.clickOnRegistrationForm();
//        registrationLoginPage.createAccount(newUser);
//    }

    @Test
    public void goToHomePage() {
        homePage.goToRegistrationLoginPage();
        registrationLoginPage.compareTitles();
        User newUser = registrationLoginPage.buildUser();
        registrationLoginPage.createAccount(newUser);
    }
}
