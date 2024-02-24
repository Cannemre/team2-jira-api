@all
Feature: Get Invalid Comment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Validate functionality of get comment request with valid issue key and invalid id
    When The user sends GET request to the Get Comment endpoint with specific key as "T2JA-24" and invalid id as "abcd"
    Then Response status code should be 404
    And The user should receive an error message