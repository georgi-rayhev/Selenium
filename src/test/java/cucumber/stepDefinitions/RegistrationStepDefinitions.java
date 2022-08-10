package cucumber.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.models.User;
import selenium.pages.LoginPage;
import selenium.pages.MyAccountPage;
import selenium.pages.RegistrationPage;
import selenium.utils.Browser;
import selenium.utils.UserHelper;

public class RegistrationStepDefinitions {

    RegistrationPage registrationPage = new RegistrationPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    User newUser = UserHelper.buildUser();

    @When("We are at Registration page")
    public void we_are_at_registration_page() {
        registrationPage.navigateToRegistrationPage();
    }

    @Then("Verify that we are at Registration page")
    public void verify_that_we_are_at_registration_page() {
        registrationPage.titleVerification();
    }

    @When("Enter valid credentials for registration")
    public void enter_valid_credentials_for_registration() {
        registrationPage.createAccount(newUser);
    }

    @Then("Verify that registration was successful")
    public void verify_that_registration_was_successful() {
        myAccountPage.titleVerificationAfterRegistration();
        Browser.closeBrowser();
    }

    @When("Try to register without credentials")
    public void try_to_register_without_credentials() {
        registrationPage.clickOnRegButton();
    }

    @Then("Verify that all proper error messages are displayed")
    public void verify_that_all_proper_error_messages_are_displayed() {
        registrationPage.isEmailErrorMessageDisplayed();
        registrationPage.isPasswordErrorMessageDisplayed();
        registrationPage.isRepeatedPasswordErrorMessageDisplayed();
        registrationPage.isNameFieldErrorMessageDisplayed();
        registrationPage.isLastNameErrorMessageDisplayed();
        registrationPage.isCountryErrorMessageDisplayed();
        registrationPage.isStateErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register with empty email")
    public void try_to_register_with_empty_email() {
        registrationPage.createAccountWithoutEmail(newUser);
    }

    @Then("Verify email error message is displayed")
    public void verify_email_error_message_is_displayed() {
        registrationPage.isEmailErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register with empty password")
    public void try_to_register_with_empty_password() {
        registrationPage.createAccountWithoutPassword(newUser);
    }

    @Then("Verify password error message is displayed")
    public void verify_password_error_message_is_displayed() {
        registrationPage.isPasswordErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register with empty repeated password")
    public void try_to_register_with_empty_repeated_password() {
        registrationPage.createAccountWithoutRepeatedPassword(newUser);
    }

    @Then("Verify repeated password error message is displayed")
    public void verify_repeated_password_error_message_is_displayed() {
        registrationPage.isRepeatedPasswordErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register without firstName")
    public void try_to_register_without_first_name() {
        registrationPage.createAccountWithoutFirstName(newUser);
    }

    @Then("Verify that first name error message is displayed")
    public void verify_that_first_name_error_message_is_displayed() {
        registrationPage.isNameFieldErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register without last name")
    public void try_to_register_without_last_name() {
        registrationPage.createAccountWithoutLastName(newUser);
    }

    @Then("Verify that last name error message is displayed")
    public void verify_that_last_name_error_message_is_displayed() {
        registrationPage.isLastNameErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Try to register without selecting country and state")
    public void try_to_register_without_selecting_country() {
        registrationPage.createAccountWithoutSelectedCountryAndState(newUser);
    }

    @Then("Verify that country and state error messages are displayed")
    public void verify_that_country_error_message_is_displayed() {
        registrationPage.isCountryErrorMessageDisplayed();
        registrationPage.isStateErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Enter credentials with invalid email")
    public void enter_credentials_with_invalid_email() {
        registrationPage.createAccountWithInvalidEmail(newUser);
    }

    @Then("Verify that email error message for invalid email is displayed")
    public void verify_that_email_error_message_for_invalid_email_is_displayed() {
        registrationPage.isInvalidEmailErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Enter credentials with invalid password")
    public void enter_credentials_with_invalid_password() {
        registrationPage.createAccountWithInvalidPassword(newUser);
    }

    @Then("Verify that error message for invalid password is displayed")
    public void verify_that_error_message_for_invalid_password_is_displayed() {
        registrationPage.isInvalidPasswordErrorMessageDisplayed();
        Browser.closeBrowser();
    }

    @When("Enter credentials with miss match passwords")
    public void enter_credentials_with_miss_match_passwords() {
        registrationPage.createAccountWithMissMatchPasswords(newUser);
    }

    @Then("Verify that error message for miss matching passwords is displayed")
    public void verify_that_error_message_for_miss_matching_passwords_is_displayed() {
        registrationPage.isRepeatedPasswordMissMatchErrorMessageDisplayed();
        Browser.closeBrowser();
    }
}
