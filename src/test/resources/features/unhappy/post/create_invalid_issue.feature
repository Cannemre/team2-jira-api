@all
Feature: Create issue
  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Verify that create issue processes does not functions with invalid key
  When The user sends Post request to create issue with invalid specific issue key
  Then Response status code should be 400
  And The user should get error message