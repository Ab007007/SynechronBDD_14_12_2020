Feature: Validate login functionality

  Scenario: Valid Login
    Given user is on login page
    When user enter valid "admin" and "manager"
    And click on login
    Then user should be able to see dashbord page

  Scenario: Invalid Login
    Given user is on login page
    When user enter invalid "admin1" or "manager1"
    And click on login
    Then user should stay on same page

Scenario: Invalid Login
    Given user is on login page
    When user enter invalid "admin1" and "Manager"
    And click on login
    Then user should stay on same page

