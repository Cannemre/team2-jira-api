@all @delete @failed
Feature: This feature is considering auth

  Scenario: I try to delete an issue without a valid token
    Given The authentication is made with invalid token to connect with api endpoints
    Then I try to delete an issue with "T2JA-48"
    And Response status code should be 401

  Scenario: I try to delete an issue without a valid token
    Given The authentication is made with invalid username to connect with api endpoints
    Then I try to delete an issue with "T2JA-48"
    And Response status code should be 401