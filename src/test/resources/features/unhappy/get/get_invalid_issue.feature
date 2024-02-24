@all
Feature: Get issue

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Verify that get issue processes does not function with invalid key
    When The user sends Get request to create issue with specific invalid issue key as "T2JA-Selcuk"
    Then Response status code should be 404
    And The error message should be displayed