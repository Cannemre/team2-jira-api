Feature: Get User
  Background:
    Given The authentication is made to connect with api endpoints
    And The user information is available

  Scenario: Get a user with specific ID
    When I send a GET request to with user ID for a specific user
    Then Response status code should be 200
    And the response should contains the user details
