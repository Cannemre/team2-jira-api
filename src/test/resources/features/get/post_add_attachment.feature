Feature: Adding attachment

  Background:
    Given The authentication is made to connect with api endpoints

  Scenario: Adding an attachment to the document.
    When I send a POST request with a specific key "T2JA-30"
    Then Response status code should be 200
    And Verify that the details of the attachment match those of the response

  Scenario Outline: Adding attachments to the document.
    When I send a POST request with a specific key "T2JA-30" and "<file_name>"
    Then Response status code should be 200
    And The response file_name should match "<file_name>"

    Examples:
    | file_name         |
    | Screenshot_4.png  |
    | Screenshot_41.png |
