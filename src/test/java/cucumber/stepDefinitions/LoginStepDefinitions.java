package cucumber.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import selenium.pages.LoginPage;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    @When("Try to login with {} and {}")
    public void tryToLogin(String loginEmail, String loginPassword) {
        loginPage.navigateToLoginPage();
        loginPage.login(loginEmail,loginPassword);
    }

    @Then("Then Verify that proper {} is displayed")
    public void verifyErrorMessage(String errorMessage){
        Assert.assertEquals(loginPage.getEmailErrorText(),errorMessage);
    }

}
