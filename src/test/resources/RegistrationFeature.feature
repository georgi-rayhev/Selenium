Feature: In this feature we will test Registration functionality

  Background:
    Given We are at Registration page
    Then  Verify that we are at Registration page

  ##Positive scenario
  Scenario: Try to make registration with valid credentials
    When Enter valid credentials
    And  Try to register
    Then Verify that registration was successful

    ##Negative scenarios
  Scenario: Try to make registration without any credentials
    When Try to register
    Then Verify that all proper error messages are displayed

    Scenario:
