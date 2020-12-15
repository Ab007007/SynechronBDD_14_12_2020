Feature: create customer

  Scenario: Create Customer using hooks
    Given User is on dashboard page
    When User click on tasks tab
    Then User is navigated to tasks page
    When User click on Add new customer button
    Then Create customer page is displayed
    When User enters "Syn-Hooks-CustomerToDelete" and  "Syn-BDD-DESCRIPTION-DEC2020" and click on create cutomer button
    Then success message should be displayed and disappeared
    And user validates the message

  Scenario: Delete Customer using hooks
    Given user is on dashboard page
    When User click on tasks tab
    Then User is navigated to tasks page
    When user search for the customer "Syn-Hooks-CustomerToDelete"
    Then customer with "Syn-Hooks-CustomerToDelete" should be displayed
    When user moves the mouse on the gear icon next to "Syn-Hooks-CustomerToDelete" and click on it
    When user click on Action and delete
    And click on delete permanently
    Then user validates the customer deletion
