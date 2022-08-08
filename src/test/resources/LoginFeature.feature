Feature: In this feature we will test Login functionality

  Background:
    Given We are at Login page
    Then  Verify we are at Login page

    ##Positive scenario
  Scenario: Login successfully
    When  Enter valid credentials
    Then  Verify login is successful

    ##Negative scenarios
  Scenario: Try to Login without email or with wrong email
    When Enter valid password
    And  Try to login
    Then Verify that email error message is displayed
    When Enter wrong email
    And  Try to login
    Then Verify that email error message is displayed

    Scenario: Try to Login without password or with wrong password
      When Enter valid email
      And  Try to login
      Then Verify that password error message is displayed
      When Enter wrong password
      And  Try to login
      Then Verify that password error message is displayed

      Scenario: Try to Login without credentials
        When Try to login without credentials
        Then Verify error messages are displayed