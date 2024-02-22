Feature: Find Users
  Background:
    Given The authentication is made to connect with api endpoints

  Scenario Outline: Find user with user email
    When The user sends GET request to find users end point with user "<email>"
    Then Response status code should be 200
    And The response email address of users should match "<email>"
    Examples:
      | email             |
      | ecan18@icloud.com |

  Scenario Outline: Find a user with user name
    When I send a GET request to with user "<name>" for a specific user
    Then Response status code should be 200
    And the response should contains the user details for a specific user
    Examples:
      | name  |
      | ERKAM |

