package cucumber.stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import selenium.pages.LoginPage;
import selenium.pages.MyAccountPage;
import selenium.utils.Browser;

import java.net.MalformedURLException;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("Open a browser")
    public void open_a_browser() throws MalformedURLException {
        Browser.openBrowser();
    }

    @When("We are at Login page")
    public void we_are_at_login_page() {
        loginPage.navigateToLoginPage();
    }
    @Then("Verify we are at Login page")
    public void verify_we_are_at_login_page() {
        loginPage.titleVerification();
    }
    @When("Try to login with {} and {}")
    public void try_to_login_with_asdaaaabv_bg_and(String loginEmail, String loginPassword) {
        loginPage.login(loginEmail, loginPassword);
    }
        @Then("Verify that proper {} is displayed")
        public void verify_that_proper_please_entered_the_valid_email_id_is_displayed (String errorMessage) {
            Assert.assertEquals(errorMessage,loginPage.getEmailErrorText());
            Browser.closeBrowser();
        }

    @Then("Verify proper {} for wrong credentials is displayed")
    public void verify_proper_please_entered_the_valid_email_id_for_wrong_credentials_is_displayed(String errorMessage) {
        loginPage.isErrorMessageForInvalidLoginDisplayed();
        Browser.closeBrowser();
    }

    @When("Enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("georgi_raychev7@abv.bg","123123@!");
    }
    @Then("Verify login is successful")
    public void verify_login_is_successful() {
       myAccountPage.titleVerification();
       Browser.closeBrowser();
    }
    }

