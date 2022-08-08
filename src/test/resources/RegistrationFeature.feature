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

    Scenario: Try to make registration without email
      When Try to register with empty email
      And  Try to register
      Then Verify email error message is displayed

      Scenario: Try to make registration without password or repeated password
        When Try to register with empty password
        And  Try to register
        Then Verify password error message is displayed
        When Try to register with empty repeated password
        And  Try to register
        Then Verify repeated password error message is displayed

        Scenario: Try to register without first name
          When Try to register without firstName
          And  Try to register
          Then Verify that first name error message is displayed

          Scenario: Try to register without last name
            When Try to register without last name
            And  Try to register
            Then Verify that last name error message is displayed

            Scenario: Try to register without selecting country
              When Try to register without selecting country
              And  Try to register
              Then Verify that country error message is displayed

              Scenario: Try to register without selecting state
                When Try to register without selecting state
                And  Try to register
                Then Verify that state error message is displayed

                Scenario: Try to register with invalid email
                  When Enter credentials with invalid email
                  Then Verify that email error message for invalid email is displayed

                  Scenario: Try to register with invalid password
                    When Enter credentials with invalid password
                    Then Verify that error message for invalid password is displayed

                    Scenario: Try to register with no matching passwords
                      When Enter credentials with miss match passwords
                      Then Verify that error message for miss matching passwords is displayed

