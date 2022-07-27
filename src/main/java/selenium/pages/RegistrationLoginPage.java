package selenium.pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import selenium.models.User;

import java.util.Locale;

import static selenium.utils.Browser.driver;

public class RegistrationLoginPage extends BasePage {

    private String title = "Мода онлайн от над 1000 топ марки | ABOUT YOU";

    // Shared fields

    By goToRegistrationForm = By.cssSelector(".dMHBmb.erJZvc");
    By goToLoginForm = By.cssSelector(".dMHBmb.erJZvc.sc-3ffazj-1.sc-3ffazj-2");
    By email = By.cssSelector("input[name='email']");
    By password = By.cssSelector("input[name='password']");
    By errorMessage = By.xpath("//*[starts-with(@data-testid, 'ErrorInfoText')]");


    // Registration fields

    By name = By.cssSelector("input[name='firstName']");
    By lastName = By.cssSelector("input[name='lastName']");
    By msRadioButton = By.cssSelector("label:nth-of-type(1) > .dfTLiG.sc-2vkvik-2");
    By mrRadioButton = By.cssSelector("label:nth-of-type(2) > .dfTLiG.sc-2vkvik-2");
    By registrationButton = By.cssSelector(".gjvFNR.jZFTVF.sc-iprg3j-0.sc-ovefx6-15 > .jPkEJg.sc-iprg3j-1");
    By nameFieldErrorMessage = By.cssSelector("div:nth-of-type(1) > div:nth-of-type(1) > .kCVWSN.sc-qywjzy-1");
    By lastNameErrorMessage = By.cssSelector("div:nth-of-type(1) > div:nth-of-type(2) > .kCVWSN.sc-qywjzy-1");
    By emailErrorMessage = By.cssSelector("div:nth-of-type(2) > div:nth-of-type(1) > .kCVWSN.sc-qywjzy-1");
    By passwordErrorMessage = By.cssSelector("div:nth-of-type(2) > div:nth-of-type(2) > .kCVWSN.sc-qywjzy-1");

    // Login fields

    By logInButton = By.cssSelector(".dEGtEE.gjvFNR.jZFTVF.sc-12p7jvx-3.sc-iprg3j-0.sc-ovefx6-15");
    By emailLoginErrorMessage = By.cssSelector("div:nth-of-type(1) > .kCVWSN.sc-qywjzy-1");
    By loginPasswordErrorMessage = By.cssSelector("div:nth-of-type(2) > .kCVWSN.sc-qywjzy-1");

    // Boolean methods

    public boolean isNameFieldErrorMessageDisplayed() {
        return findElement(nameFieldErrorMessage).isDisplayed();
    }

    public boolean isLastNameErrorMessageDisplayed() {
        return findElement(lastNameErrorMessage).isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        return findElement(emailErrorMessage).isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return findElement(passwordErrorMessage).isDisplayed();
    }

    public boolean isLoginEmailErrorMessageDisplayed() {
        return findElement(emailLoginErrorMessage).isDisplayed();
    }

    public boolean isLoginPasswordErrorMessageDisplayed() {
        return findElement(loginPasswordErrorMessage).isDisplayed();
    }


    public void compareTitles() {
        verifyTitlesAreEquals(title);
    }

    public User buildUser() {
        Faker bgFaker = new Faker(new Locale("en-GB"));
        Faker faker = new Faker();
        return User.builder()
                .email(faker.internet().emailAddress())
                .firstName(bgFaker.name().firstName())
                .lastName(bgFaker.name().lastName())
                .password(faker.internet().password())
                .build();
    }

    public void createAccount(User user) {
        writeText(name,user.getFirstName());
        writeText(lastName,user.getLastName());
        writeText(email,user.getEmail());
        writeText(password, user.getPassword());
        clickOn(mrRadioButton);
        clickOn(registrationButton);
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
    }
}
