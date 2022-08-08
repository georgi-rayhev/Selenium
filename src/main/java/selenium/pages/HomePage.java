package selenium.pages;

import org.openqa.selenium.By;
import selenium.models.User;

import static selenium.utils.Browser.driver;

public class HomePage extends BasePage {
    private final static String HOME_PAGE_URL = "http://localhost/";

    By accountButton = By.cssSelector(".pe-7s-user-female");
    By loginButton = By.linkText("Login");
    By registrationButton = By.linkText("Register");

    public void goToHomePage(){
        navigateTo(HOME_PAGE_URL);
    }

}


