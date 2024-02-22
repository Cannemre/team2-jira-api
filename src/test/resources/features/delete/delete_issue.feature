Feature: This feature is about deleting an issue

  Background: This is for authentication processes
    Given The authentication is made to connect with api endpoints

    Scenario: I create an existing issue
      Given I create an issue
      Then I try to delete it
      And Response status code should be 204