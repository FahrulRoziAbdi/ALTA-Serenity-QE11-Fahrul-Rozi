Feature: API Automation Testing ALTA QE Batch 11
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
    And Validate get list user JSON Schema
#    And Print if status code 200 OK
#    And Get log body
#    And Get log all

    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create new user with valid JSON
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 created
    And Response body name was "Fahrul" and job was "QA Leader"

  @Latihan
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name was "Fahrul" and job was "QA"
    And Validate update user JSON Schema
    Examples:
          | id |
          | 1  |
          | 2  |

  @Latihan
  Scenario Outline: Delete user
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204 No Content
    Examples:
          | id |
          | 1  |
          | 2  |
          | 3  |
