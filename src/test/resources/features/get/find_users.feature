Feature: Find Users
  Background:
    Given The authentication is made to connect with api endpoints

  Scenario:
    When The user sends GET request to find users end point with specific query
    Then Response status code should be 200
    And The response displayed name of users should contain query