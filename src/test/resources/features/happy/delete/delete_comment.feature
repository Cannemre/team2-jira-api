@all @smoke
Feature: This feature is about deleting an comment

  Background: This is for authentication processes
    Given The authentication is made to connect with api endpoints

  Scenario: Validate delete comment method functionality
    When The user sends DELETE request to the delete comment endpoint with specific issue key as "T2JA-40" and specific id as "10084"
    Then Response status code should be 204

  Scenario: Validate delete comment method functionality
    When The user sends DELETE request to the delete comment endpoint with specific issue key as "T2JA-40" and specific invalid id as "100000009"
    Then Response status code should be 404

