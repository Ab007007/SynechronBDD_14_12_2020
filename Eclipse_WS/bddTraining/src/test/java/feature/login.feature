Feature: Validate login functionality

  Scenario: Valid Login
    Given user is on login page
    When user enter valid username and password
    And click on login
    Then user should be able to see dashbord page

  Scenario: Invalid Login
    Given user is on login page
    When user enter invalid username or password
    And click on login
    Then user should stay on same page

Scenario: Invalid Login
    Given user is on login page
    When user enter invalid username and password
    And click on login
    Then user should stay on same page

