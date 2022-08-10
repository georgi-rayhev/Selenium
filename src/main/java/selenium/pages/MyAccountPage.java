package selenium.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

    By messageForSuccessfulLRegistration = By.cssSelector(".css-1ad3zal.react-toast-notifications__toast__content");
    String titleAfterLogin = "Default store | Login";
    String titleAfterRegistration = "Default store | My Account";

    public boolean isMessageForSuccessfulRegistrationDisplayed() {
        String errorMessage = "'You have successfully registerd in to this website.";
        findElement(messageForSuccessfulLRegistration).getText().equalsIgnoreCase(errorMessage);
        return findElement(messageForSuccessfulLRegistration).isDisplayed();
    }
    public void titleVerificationAfterLogin() {
        verifyTitlesAreEquals(titleAfterLogin);
    }

    public void titleVerificationAfterRegistration() {
        verifyTitlesAreEquals(titleAfterRegistration);
    }
}
