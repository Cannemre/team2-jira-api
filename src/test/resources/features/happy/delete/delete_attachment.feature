Feature: Delete attachment

  Background: This is for authentication processes
    Given The authentication is made to connect with api endpoints
  Scenario:
    When The user sends DELETE request to the delete attachment endpoint with specific id as "10086"
    Then Response status code should be 204


