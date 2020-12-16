
Feature: Validate login functionality

  @smoke @actitime @regression
  Scenario: Valid Login
    Given user is on login page
    When user enter valid "admin" and "manager"
    And click on login
    Then user should be able to see dashbord page

  @actitime @regression
  Scenario: Invalid Login
    Given user is on login page
    When user enter invalid "admin1" or "manager1"
    And click on login
    Then user should stay on same page

  @actitime
  Scenario: Invalid Login
    Given user is on login page
    When user enter invalid "admin1" and "Manager"
    And click on login
    Then user should stay on same page
