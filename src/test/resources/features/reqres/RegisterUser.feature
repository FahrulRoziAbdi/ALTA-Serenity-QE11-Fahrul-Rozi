Feature: Testing register user Reqres API
  @Tugas
  Scenario: Post register user with valid json Reqres API
    Given Register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id was 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register user

  @Tugas
  Scenario: Post register user with invalid json Reqres API
    Given Register user with invalid json
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing password"
    And Validate json schema invalid register