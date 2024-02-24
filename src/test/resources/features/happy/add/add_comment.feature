@all @smoke
Feature: This feature is about adding a comment
  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Test add comment method functionality with valid endpoint
    When The user sends POST request to add comment endpoint with specific issue key as "T2JA-40"
    Then Response status code should be 201
    And The comment id should not be empty or null
    And The response text should be same with the given text in json file

  Scenario: Test add comment method functionality with invalid endpoint
    When The user sends POST request to add comment endpoint with specific invalid issue key as "T2ffA-40"
    Then Response status code should be 404