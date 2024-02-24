@all @delete
Feature: This feature is about deleting an issue

  Background: This is for authentication processes
    Given The authentication is made to connect with api endpoints

  Scenario Outline: I delete an existing issue
    Then I try to delete an issue with "<issueKey>"
    And Response status code should be <statusCode>
    Examples:
      | issueKey | statusCode |
      | T2JA-42  | 204        |
      | T2JA-42  | 404        |
      | 🥒🥒🥒🥒 | 404        |

  Scenario Outline: I delete an existing issue with using delete subtasks query param
    Then I try to delete an issue with "<issueKey>" and "<deleteSubtasks>"
    And Response status code should be <statusCode>
    Examples:
      | issueKey | deleteSubtasks | statusCode |
      | T2JA-59  | true           | 204        |
      | T2JA-44  | false          | 400        |
      | T2JA-60  | 🥒             | 204        |
