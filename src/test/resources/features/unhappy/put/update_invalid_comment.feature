Feature: Invalid update comment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Validate functionality of update comment request with valid issue key and invalid id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "T2JA-28" and invalid comment id as "1234567"
    Then Response status code should be 404
    And The error message should be displayed