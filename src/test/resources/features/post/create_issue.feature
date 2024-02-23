Feature: Create issue
  Background:
    Given The authentication is made to connect with api endpoints

    Scenario:
        When The user sends Post request to create issue
        Then Response status code should be 201
        And The Time should be under 5000 ms on the response