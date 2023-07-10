Feature: Testing Login User Reqres API
  @Tugas
  Scenario: Post Login with valid email and password
    Given Post login user with valid json
    When Send request post login user
    And Response body token should be "QpwL5tke4Pnpja7X4"
    Then Status code should be 200 OK
    And Validate json schema login user

    @Tugas
    Scenario: Post Login with invalid email
      Given Post login user with invalid json
      When Send request post login user
      Then Status code should be 400 Bad Request
      And Response body error should be "Missing password"
      And Validate json schema invalid login user

      @Tugas
      Scenario: Post login with invalid json schema
        Given Post login user with invalid json schema
        When Send request post login user
        Then Status code should be 400 Bad Request
        And Response body error should be "Missing password"
        And Validate json schema login unsuccessfully