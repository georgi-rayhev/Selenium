import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenium.models.User;
import selenium.pages.*;
import selenium.utils.Browser;
import selenium.utils.UserHelper;

import java.net.MalformedURLException;

import static selenium.utils.Browser.driver;

public class TestClass {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    User newUser = UserHelper.buildUser();

    @BeforeEach
    public void startBrowser() throws MalformedURLException {
        Browser.openBrowser();
    }

    @AfterEach
    public void closeBrowser() {
        Browser.closeBrowser();
    }

    @Test
    public void registration() {
        registrationPage.navigateToRegistrationPage();
        registrationPage.createAccount(newUser);
  }

  @Test
    public void login() {
        loginPage.navigateToLoginPage();
        loginPage.login(newUser);

  }

}
