package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
    By selectStateDropDown = By.xpath("//div[@class='tab-content']/div[2]//form/div[7]/select");
    By errorMessage = By.cssSelector(".error-msg");
    By usedEmailErrorMessage = By.xpath("//div[.='Registering customer already exist']");
    By emailErrorMessage = By.cssSelector("div:nth-of-type(1) > .error-msg");
    By nameFieldErrorMessage = By.cssSelector("div:nth-of-type(4) > .error-msg");
    By lastNameErrorMessage = By.cssSelector("div:nth-of-type(5) > .error-msg");
    By passwordErrorMessage = By.cssSelector("div:nth-of-type(2) > .error-msg");
    By passwordRepeatedErrorMessage = By.cssSelector("div:nth-of-type(3) > .error-msg");
    By stateErrorMessage = By.cssSelector("div:nth-of-type(7) > .error-msg");
    By countryErrorMessage = By.cssSelector("div:nth-of-type(6) > .error-msg");

    public void titleVerification() {
        verifyTitlesAreEquals(title);
    }

    public void clickOnRegButton(){
        WebElement element = driver.findElement(By.xpath("//span[.='Register']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public boolean isErrorMessageDisplayed() {
        return findElement(errorMessage).isDisplayed();
    }

    public boolean isNameFieldErrorMessageDisplayed() {
        String errorMessage = "Firstname is required";
        findElement(nameFieldErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(nameFieldErrorMessage).isDisplayed();
    }

    public boolean isLastNameErrorMessageDisplayed() {
        String errorMessage = "Lastname is required";
        findElement(lastNameErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(lastNameErrorMessage).isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        String errorMessage = "Email is required";
        findElement(emailErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(emailErrorMessage).isDisplayed();
    }
    public boolean isInvalidEmailErrorMessageDisplayed() {
        String errorMessage = "Please entered the valid email id";
        findElement(emailErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(emailErrorMessage).isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed() {
        String errorMessage = "Password is required";
        findElement(passwordErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(passwordErrorMessage).isDisplayed();
    }

    public boolean isInvalidPasswordErrorMessageDisplayed() {
        String errorMessage = "Password must be minimum of 8 characters atleast one number and one special character";
        findElement(passwordErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(passwordErrorMessage).isDisplayed();
    }

    public boolean isRepeatedPasswordErrorMessageDisplayed() {
        String errorMessage = "Repeat Password is required";
        findElement(passwordRepeatedErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(passwordRepeatedErrorMessage).isDisplayed();
    }

    public boolean isRepeatedPasswordMissMatchErrorMessageDisplayed() {
        String errorMessage = "Repeat Password should be the same as a password";
        findElement(passwordRepeatedErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(passwordRepeatedErrorMessage).isDisplayed();
    }

    public boolean isCountryErrorMessageDisplayed() {
        String errorMessage = "Country is required";
        findElement(countryErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(countryErrorMessage).isDisplayed();
    }

    public boolean isStateErrorMessageDisplayed() {
        String errorMessage = "State is required";
        findElement(stateErrorMessage).getText().equalsIgnoreCase(errorMessage);
        return findElement(stateErrorMessage).isDisplayed();
    }

    public boolean isAlreadyUsedEmailErrorMessageIsDisplayed() {
        return findElement(usedEmailErrorMessage).isDisplayed();
    }


    public void selectCountry() {
        Select select = new Select(findElement(selectCountryDropDown));
        select.selectByIndex(2);
        Assert.assertFalse(select.isMultiple());
    }

    public void selectState() {
        Select select = new Select(findElement(selectStateDropDown));
        select.selectByIndex(3);
        Assert.assertFalse(select.isMultiple());
    }
    public void navigateToRegistrationPage(){
        navigateTo(REGISTRATION_URL);
    }

    public void createAccount(User user) {
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        writeText(email,user.getEmail());
        writeText(password, user.getPassword());
        writeText(repeatPassword,user.getPassword());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterRegistration();
    }

    public void createAccountWithInvalidEmail(User user) {
        writeText(email,"asdasdasd.bg");
        writeText(password,user.getPassword());
        writeText(repeatPassword,user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithInvalidPassword(User user) {
        writeText(email,user.getEmail());
        writeText(password,"12312@!");
        writeText(repeatPassword,user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithoutLastName(User user) {
        writeText(email, user.getEmail());
        writeText(password,user.getPassword());
        writeText(repeatPassword,user.getPassword());
        writeText(firstName,user.getFirstName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithoutFirstName(User user) {
        writeText(email,user.getEmail());
        writeText(password,user.getPassword());
        writeText(repeatPassword,user.getPassword());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithoutEmail(User user) {
        writeText(password,user.getPassword());
        writeText(repeatPassword,user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
    }

    public void createAccountWithoutPassword(User user) {
        writeText(email,user.getEmail());
        writeText(repeatPassword,user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithoutRepeatedPassword(User user) {
        writeText(email,user.getEmail());
        writeText(password,user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithoutSelectedCountryAndState(User user) {
        writeText(email,user.getEmail());
        writeText(password,user.getPassword());
        writeText(repeatPassword, user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }

    public void createAccountWithMissMatchPasswords(User user) {
        writeText(email,user.getEmail());
        writeText(password, "123123@!");
        writeText(repeatPassword,"123132");
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully and congrats you find a BUG <<<<<>>>>>>");
        }
    }

    public void createAccountWithAlreadyUsedEmail(User user) {
        writeText(email,"georgi_raychev7@abv.bg");
        writeText(password,user.getPassword());
        writeText(repeatPassword, user.getPassword());
        writeText(firstName,user.getFirstName());
        writeText(lastName,user.getLastName());
        selectCountry();
        selectState();
        clickOnRegButton();
        if(driver.findElements(errorMessage).size() != 0) {
            System.out.println("User is not created");
        } else {
            System.out.println("User was created successfully");
        }
        myAccountPage.titleVerificationAfterLogin();
    }
}
