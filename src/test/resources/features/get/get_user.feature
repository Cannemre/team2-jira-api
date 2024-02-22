Feature: Get User
  Background:
    Given The authentication is made to connect with api endpoints
    And The user information is available

  Scenario: Get a user with specific ID
    When I send a GET request to with user ID for a specific user
    Then Response status code should be 200
    And the response should contains the user details

  Scenario Outline: Get a user with specific ID and validate user ID in response
    When I send a GET request to with account "<ID>" for a specific user
    Then Response status code should be 200
    And The response account ID of users should match "<ID>"
    Examples:
      | ID                       |
      | 63d3afe30d930a766df14ce5 |
      | 712020:5cd8601b-9c6d-484c-9ed4-4a4461bd7eb3 |
      | 712020:dfc25f9c-fceb-4b4a-9bce-71ab738cd69c |
      | 712020:4ed4d39b-e62f-46f6-8115-5fc2f575769f |
      | 712020:c7d0932d-d3ce-4f56-a7b5-c6631d38ca3c |
