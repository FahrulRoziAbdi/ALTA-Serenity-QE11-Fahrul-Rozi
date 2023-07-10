Feature: Testing User Reqres API
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

    @Tugas
  Scenario Outline: Get single user with valid id
      Given Get single user with valid id <id>
      When Send request get single user
      Then Status code should be 200 OK
      And Validate json schema get single user
      Examples:
        | id |
        | 1  |
        | 2  |
  @Tugas
 Scenario Outline: Get single user not found with invalid id
    Given Get single user with invalid id <id>
    When Send request get single user
    Then Status code should be 404
    Examples:
      | id |
      | 23 |

