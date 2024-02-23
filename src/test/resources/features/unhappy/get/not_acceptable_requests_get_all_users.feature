@all @king
Feature: Get All User invalid Header Scenarios

  Background:
    Given The authentication is made with invalid content type to connect with api endpoints

  Scenario: User details should match the expected response from the API
    Then The user sends GET request to get all users endpoint to verify response
    Then Response status code should be 406

  Scenario: This scenario is testing startsAt query parameter
    When The user sends GET request to get all users endpoint with startAt query parameter "5" to verify response
    Then Response status code should be 406

  Scenario: This scenario is testing maxResult query parameter
    When The user sends GET request to get all users endpoint with maxResult query parameter "10" to verify response
    Then Response status code should be 406

  Scenario: This scenario is testing maxResult and startAt query parameters
    When The user sends GET request to get all users endpoint with multiple query parameters "5" "10" to verify response
    Then Response status code should be 406



