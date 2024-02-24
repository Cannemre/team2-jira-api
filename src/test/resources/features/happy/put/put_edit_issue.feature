@all @smoke
Feature: Edit Issue

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario Outline: Adding a label to the document whose type is 'task' and which has the VALID key.
    When I send a PUT request with a specific key "<key>"
    Then Response status code should be 204
    And The Time should be under 3000 ms on the response

    Examples:
      | key     |
      | T2JA-30 |

  Scenario Outline: Adding a label to the document whose type is 'task' and which has the INVALID key.
    When I send a PUT request with a specific key "<key>"
    Then Response status code should be 404

    Examples:
      | key         |
      | T2JA-30FAKE |
