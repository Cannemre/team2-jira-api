@all
Feature: This scenario sends invalid query params

  Background:
    Given The authentication is made to connect with api endpoints


  Scenario Outline: This scenario is testing startsAt query parameter
    When The user sends GET request to get all users endpoint with startAt query parameter "<startAt>" to verify response
    Then Response status code should be 400
    Examples:
      | startAt  |
      | -1       |
      | A        |
      | 🥒🥒🥒🥒 |


  Scenario Outline: This scenario is testing maxResult query parameter
    When The user sends GET request to get all users endpoint with maxResult query parameter "<maxResult>" to verify response
    Then Response status code should be 400
    Examples:
      | maxResult |
      | -1        |
      | A         |
      | 🥒🥒🥒🥒  |


  Scenario Outline: This scenario is testing maxResult query parameter
    When The user sends GET request to get all users endpoint with multiple query parameters "<startAt>" "<maxResult>" to verify response
    Then Response status code should be 400
    Examples:
      | maxResult | startAt |
      | -1        | -1      |
      | A         | A       |
      | 🥒🥒🥒🥒  | 🥒🥒    |
