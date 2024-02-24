@all @smoke
Feature: Retrieve Recent Projects from JIRA

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: User successfully retreives recent projects

    When the client sends a Get request to get recent projects
    Then Response status code should be 200
    And the response should contain recent project data

  Scenario: User successfully retreives recent projects

    When the client sends a Get request to get recent projects
    Then Response status code should be 200
    And the response should have the same project quantity with Recent Projects

  Scenario: User try to reach Recent Projects with invalid request

    When the user sends a Get Invalid Request to get recent projets
    Then Response status code should be 404

  Scenario: User successfully retreives a project with valid projectID
    When the user send get request to Get Project Endpoint with valid projectId
    Then Response status code should be 200
    And the response should contain specific project

  Scenario: User successfully retreives a project with valid projectID
    When the user send get request to Get Project Endpoint with second valid projectId
    Then Response status code should be 200