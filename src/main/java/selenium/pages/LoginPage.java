package selenium.pages;

import org.openqa.selenium.By;
import selenium.models.User;

public class LoginPage extends BasePage {

    MyAccountPage myAccountPage = new MyAccountPage();

    private final static String LOGIN_URL = "http://localhost/login";
    private String title = "| Login";

    By email = By.name("username");
    By password = By.name("loginPassword");
    By loginButton = By.cssSelector(".tab-content > div:nth-of-type(1)");

    String emailForLogin = "georgi_raychev7@abv.bg";
    String passwordForLogin = "123123@!";

    public void navigateToLoginPage() {
        navigateTo(LOGIN_URL);
        verifyTitlesAreEquals(title);
    }

    public void login(User user) {
        writeText(email,emailForLogin);
        writeText(password, passwordForLogin);
        clickOn(loginButton);
        myAccountPage.verifyTitleAfterLogin();
    }
}
