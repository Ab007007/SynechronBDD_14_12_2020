Feature: create customer

  Background: 
    Given user create a browser instance
    And launch actitime application
    When user enters valid "admin" and "manager"
    And click on login button
    Then User should be on dashboard page

  Scenario: Create Customer using hooks
    Given User is on dashboard page
    When User click on tasks tab
    Then User is navigated to tasks page
    When User click on Add new customer button
    Then Create customer page is displayed
    When User enters "Syn-BackGround-CustomerToDelete" and  "Syn-BDD-DESCRIPTION-DEC2020" and click on create cutomer button
    Then success message should be displayed and disappeared
    And user validates the message
    And logout from the application

  Scenario: Delete Customer using hooks
    Given user is on dashboard page
    When User click on tasks tab
    Then User is navigated to tasks page
    When user search for the customer "Syn-BackGround-CustomerToDelete"
    Then customer with "Syn-BackGround-CustomerToDelete" should be displayed
    When user moves the mouse on the gear icon next to "Syn-BackGround-CustomerToDelete" and click on it
    When user click on Action and delete
    And click on delete permanently
    Then user validates the customer deletion
    And logout from the application
