@all
Feature: Get All User
  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: User details should match the expected response from the API
    When The user sends GET request to get all users endpoint
    Then Response status code should be 200