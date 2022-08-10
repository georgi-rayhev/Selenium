Feature: In this feature we will test Registration functionality

  Background:
    Given Open a browser
    When  We are at Registration page
    Then  Verify that we are at Registration page

  ##Positive scenario
@Reg
    Scenario: Try to make registration with valid credentials
      When Enter valid credentials for registration
      Then Verify that registration was successful

#    ##Negative scenarios
  @Reg
      Scenario: Try to make registration without any credentials
        When Try to register without credentials
        Then Verify that all proper error messages are displayed
  @Reg
        Scenario: Try to make registration without email
          When Try to register with empty email
          Then Verify email error message is displayed
  @Reg
          Scenario: Try to make registration without password
            When Try to register with empty password
            Then Verify password error message is displayed
  @Reg
            Scenario: Try to make registration without repeated password
              When Try to register with empty repeated password
              Then Verify repeated password error message is displayed
  @Reg
            Scenario: Try to register without first name
              When Try to register without firstName
              Then Verify that first name error message is displayed
  @Reg
              Scenario: Try to register without last name
                When Try to register without last name
                Then Verify that last name error message is displayed
  @Reg
                Scenario: Try to register without selecting country and state
                  When Try to register without selecting country and state
                  Then Verify that country and state error messages are displayed
  @Reg
                    Scenario: Try to register with invalid email
                      When Enter credentials with invalid email
                      Then Verify that email error message for invalid email is displayed
  @Reg
                      Scenario: Try to register with invalid password
                        When Enter credentials with invalid password
                        Then Verify that error message for invalid password is displayed

                          @Bug
                          Scenario: Try to register with no matching passwords
                            When Enter credentials with miss match passwords
                            Then Verify that error message for miss matching passwords is displayed

