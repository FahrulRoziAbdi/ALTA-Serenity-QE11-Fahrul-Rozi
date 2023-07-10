Feature: Testing delay response Reqres API
  @Tugas
  Scenario Outline: Get delay response with valid parameter delay
    Given Get delay response with valid page <page>
    When Send request get delay response
    Then Status code should be 200 OK
    And Validate json schema delay response
    Examples:
      | page |
      | 1    |
      | 2    |
      | 3    |