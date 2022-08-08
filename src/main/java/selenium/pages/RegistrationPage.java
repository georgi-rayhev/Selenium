package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import selenium.models.User;

import static selenium.utils.Browser.driver;

public class RegistrationPage extends BasePage {

    MyAccountPage myAccountPage = new MyAccountPage();

    private final static String REGISTRATION_URL = "http://localhost/register";
    private String title = "| Login";

    By email = By.name("email");
    By password = By.name("password");
    By repeatPassword = By.name("repeatPassword");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By selectCountryDropDown = By.xpath("//div[@class='tab-content']/div[2]//form/div[6]/select");
    By countryOption = By.xpath("//div[@class='tab-content']/div[2]//form/div[6]/select//option[3]");
    By selectStateDropDown = By.xpath("//div[@id='root']/div[4]//div[@class='tab-content']/div[2]//form/div[7]/select");
    By stateOption = By.xpath("//div[@class='tab-content']/div[2]//form/div[7]/select//option[@value='QC']");
    By registrationButton = By.xpath("//span[.='Register']");
    By errorMessage = By.cssSelector(".error-msg");
    By emailErrorMessage = By.cssSelector("div:nth-of-type(1) > .error-msg");
    By nameFieldErrorMessage = By.cssSelector("div:nth-of-type(4) > .error-msg");
    By lastNameErrorMessage = By.cssSelector("div:nth-of-type(5) > .error-msg");
    By passwordErrorMessage = By.cssSelector("div:nth-of-type(2) > .error-msg");
    By passwordRepeatedErrorMessage = By.cssSelector("div:nth-of-type(3) > .error-msg");
    By stateErrorMessage = By.cssSelector("div:nth-of-type(7) > .error-msg");
    By countryErrorMessage = By.cssSelector("div:nth-of-type(6) > .error-msg");

    public boolean isErrorMessageDisplayed() {
        return findElement(errorMessage).isDisplayed();
    }

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

    public boolean isRepeatedPasswordErrorMessageDisplayed() {
        return findElement(passwordRepeatedErrorMessage).isDisplayed();
    }

    public boolean isStateErrorMessageDisplayed() {
        return findElement(stateErrorMessage).isDisplayed();
    }

    public boolean isCountryErrorMessageDisplayed() {
        return findElement(countryErrorMessage).isDisplayed();
    }

    public void selectCountry() {
    clickOn(selectCountryDropDown);
    clickOn(countryOption);
    }

    public void selectState() {
        clickOn(selectStateDropDown);
        clickOn(stateOption);
    }
    public void navigateToRegistrationPage(){
        navigateTo(REGISTRATION_URL);
        verifyTitlesAreEquals(title);
    }

    public void createAccount(User user) {
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        writeText(email,user.getEmail());
        writeText(password, user.getPassword());
        writeText(repeatPassword,user.getPassword());
        selectCountry();
        selectState();
        clickOn(registrationButton);
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.verifyTitle();
    }


}
