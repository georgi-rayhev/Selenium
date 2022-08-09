package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static selenium.utils.Browser.driver;

public class LoginPage extends BasePage {

    MyAccountPage myAccountPage = new MyAccountPage();

    private final static String LOGIN_URL = "http://localhost/login";
    private String title = "| Login";

    By email = By.name("username");
    By password = By.name("loginPassword");
    By errorMessageForInvalidLogin = By.cssSelector(".css-1ad3zal.react-toast-notifications__toast__content");
    By errorMessage = By.cssSelector(".error-msg");


    public boolean isErrorMessageForInvalidLoginDisplayed() {
        String errorMessage = "Incorrect username or password";
        findElement(errorMessageForInvalidLogin).getText().equalsIgnoreCase(errorMessage);
        return findElement(errorMessageForInvalidLogin).isDisplayed();
    }


    public void clickOnLoginButton() {
        WebElement element = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Login']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_URL);
    }

    public void titleVerification(){
        verifyTitlesAreEquals(title);
    }
    public void login(String emailForLogin, String passwordForLogin)  {
        writeText(email,emailForLogin);
        writeText(password,passwordForLogin);
        clickOnLoginButton();
    }

    public String getEmailErrorText() {
        String errorText = findElement(errorMessage).getText();
        return errorText;
    }

    public String getFailedLoginErrorText() {
        String errorText = findElement(errorMessageForInvalidLogin).getText();
        return errorText;
    }
}

