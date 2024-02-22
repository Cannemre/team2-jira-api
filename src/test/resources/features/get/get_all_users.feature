@all @king
Feature: Get All User Happy Scenarios

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: User details should match the expected response from the API
    Then The user sends GET request to get all users endpoint
    Then Response status code should be 200


  Scenario Outline: This scenario is testing startsAt query parameter
    When The user sends GET request to get all users endpoint with startAt query parameter "<startAt>"
    Then Response status code should be 200
    Examples:
      | startAt |
      | 0        |
      | 10       |
      | 24       |

  Scenario Outline: This scenario is testing maxResult query parameter
    When The user sends GET request to get all users endpoint with maxResult query parameter "<maxResults>"
    Then Response status code should be 200
    Examples:
      | maxResults |
      | 1          |
      | 10         |
      | 25         |

  Scenario Outline: This scenario is testing maxResult query parameter
    When The user sends GET request to get all users endpoint with multiple query parameters "<maxResults>" "<startAt>"
    Then Response status code should be 200
    Examples:
      | maxResults | startAt |
      | 1          | 0        |
      | 10         | 10       |
      | 25         | 24       |




