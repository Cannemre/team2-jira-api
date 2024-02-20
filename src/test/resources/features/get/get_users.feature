@all
Feature: Validation user management api

  Scenario: User details should match the expected response from the API
    Then I send get request to assert response for all users