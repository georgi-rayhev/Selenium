package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final static String HOME_PAGE_URL = "https://www.aboutyou.bg/";

    private String title = "";


    By profileIcon = By.cssSelector(".userIcon--zdWV7");
    By headerLogo = By.cssSelector("[class='sc-t6bp6s-3 figUyy']");
    By shoes = By.xpath("//span[@data-test-id='Label_Обувки']");
    By cookiesOkButton = By.cssSelector("#onetrust-accept-btn-handler");



    public void goToHomePage(){
        navigateTo(HOME_PAGE_URL);
    }

    public void goToRegistrationLoginPage() {
        navigateTo(HOME_PAGE_URL);
        clickOn(cookiesOkButton);
        clickOn(profileIcon);
    }






}


