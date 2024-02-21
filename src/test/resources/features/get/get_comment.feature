Feature: Get Comment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario:
    When The user sends get request to the Get Comment endpoint with specific key as "T2JA-24" and specific id as "10075"
    Then Response status code should be 200
    And The Time should be under 4000 ms on the response
    And The response text should be "Mehmet"

  Scenario:
    When The user sends get request to the Get Comment endpoint with specific key as "T2JA-24" and specific id as "10075"
    Then Response status code should be 200
    And The id should not be null and empty on the response

  Scenario:
    When The user sends get request to the Get Comment endpoint with specific key as "T2JA-24" and invalid id as "abcd"
    Then Response status code should be 404
    And The user should receive an error message