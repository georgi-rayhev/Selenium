Feature : In this feature we will test login form

  @Test
  Scenario Outline: Login test
    When Try to login with <email> and <password>
    Then Verify that proper <error> is displayed
      Examples:
        |  email    | password  | error                            |
        | aaadabv.bg| 123123@!  |Please entered the valid email id |