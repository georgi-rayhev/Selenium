package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static selenium.utils.Browser.driver;

public class LoginPage extends BasePage {

    MyAccountPage myAccountPage = new MyAccountPage();

    private final static String LOGIN_URL = "http://localhost/login";
    private String title = "| Login";

    By email = By.name("username");
    By password = By.name("loginPassword");
    By loginButton = By.xpath("//button[@type='submit' and contains(., 'Login')]");
    By errorMessageForInvalidLogin = By.xpath("//div[.='Incorrect username or password']");
    By errorMessageForInvalidEmail = By.cssSelector(".error-msg");
    By cookiesButton = By.cssSelector("#rcc-confirm-button");



    public boolean isErrorMessageForInvalidLoginDisplayed() {
        String errorMessage = "Incorrect username or password";
        findElement(errorMessageForInvalidLogin).getText().equalsIgnoreCase(errorMessage);
        return findElement(errorMessageForInvalidLogin).isDisplayed();
    }

    public boolean isErrorMessageForInvalidEmailDisplayed() {
        String errorMessage = "Please entered the valid email id";
        findElement(errorMessageForInvalidEmail).getText().equalsIgnoreCase(errorMessage);
        return findElement(errorMessageForInvalidEmail).isDisplayed();
    }

    public String getEmailErrorText() {
        findElement(errorMessageForInvalidEmail).getText();
        return String.valueOf(findElement(errorMessageForInvalidEmail));
    }

    public void clickOnLoginButton() {
        WebElement element = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Login']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_URL);
        verifyTitlesAreEquals(title);
    }
    public void login(String emailForLogin, String passwordForLogin)  {
        writeText(email,emailForLogin);
        writeText(password,passwordForLogin);
        clickOnLoginButton();
        myAccountPage.verifyTitle();
    }
}

