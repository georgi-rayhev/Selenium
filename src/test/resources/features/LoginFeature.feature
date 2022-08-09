@Login
Feature: In this feature we will test Login functionality

  Background:
    Given Open a browser
    When  We are at Login page
    Then  Verify we are at Login page

    ##Positive scenario
@Login2
  Scenario: Login successfully
    When  Enter valid credentials
    Then  Verify login is successful

    ##Negative scenarios

        Scenario Outline: Failed login with missing or invalid credentials
          When Try to login with <email> and <password>
          Then Verify that proper <error> is displayed
          Examples:
            |  email                |  password  | error                            |
            |    asdaaaabv.bg       | 123123@!   |Please entered the valid email id |
            |                       | 123123@!   |Email is required                 |
            |georgi_raychev7@abv.bg |            |Password is required              |
            |                       |            |Email is required                 |

        Scenario Outline: Failed login with wrong credentials
          When Try to login with <email> and <password>
          Then Verify proper error for wrong credentials is displayed
          Examples:
            |  email                |  password  |
            |    asdaaa@abv.bg      | 123123@!   |
            | georgi_raychev7@abv.bg| 123123     |
            |georgi_raychev@abv.bg  | 1231231    |