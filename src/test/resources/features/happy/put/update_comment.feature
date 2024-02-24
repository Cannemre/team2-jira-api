@all
Feature: Update Comment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Validate functionality of update comment request with valid issue key and id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "T2JA-28" and comment id as "10078"
    Then Response status code should be 200
    And The Time should be under 6000 ms on the response

  Scenario: Validate functionality of update comment request with valid issue key and id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "T2JA-28" and comment id as "10078"
    Then Response status code should be 200
    And The content of request should match with the content of the response



