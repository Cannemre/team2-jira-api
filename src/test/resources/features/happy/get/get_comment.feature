Feature: Get Comment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Validate functionality of get comment request with valid issue key and id
    When The user sends GET request to the Get Comment endpoint with specific key as "T2JA-24" and specific id as "10075"
    Then Response status code should be 200
    And The Time should be under 6000 ms on the response
    And The response text should match "Mehmet"

  Scenario: Validate functionality of get comment request with valid issue key and id
    When The user sends GET request to the Get Comment endpoint with specific key as "T2JA-24" and specific id as "10075"
    Then Response status code should be 200
    And The id should not be null and empty on the response