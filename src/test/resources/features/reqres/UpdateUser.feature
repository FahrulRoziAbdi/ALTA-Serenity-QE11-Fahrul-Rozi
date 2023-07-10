Feature: Testing Update user Reqres API
  @Latihan
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name was "Fahrul" and job was "QA"
    Examples:
      | id |
      | 1  |
      | 2  |

    @Tugas
    Scenario Outline: Patch update user with valid parameter id and JSON
      Given Patch update user with valid id <id> and json
      When Send request patch update user
      Then Status code should be 200 OK
      And Response body name was "Fahrul" and job was "QA"
      And Validate json schema patch update user
      Examples:
        | id |
        | 1  |
        | 2  |
        | 3  |