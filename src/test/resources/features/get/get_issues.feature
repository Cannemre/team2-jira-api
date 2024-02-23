Feature: Get issue

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Verify that get issue processes functions properly with valid key
    When The user sends Get request to create issue with specific issue key as "T2JA-54"
    Then Response status code should be 200
    And Issue id is not null and empty