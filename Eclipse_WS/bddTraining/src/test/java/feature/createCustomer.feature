Feature: Create Customer

  Scenario: Customer should be created successfully
    #Given User is loggedin to the actitime application using "admin" and "manager"
    When User click on tasks tab
    Then User is navigated to tasks page
    When User click on Add new customer button
    Then Create customer page is displayed
    When User enters "Syn-BDD-Customer-2DEC2020" and  "Syn-BDD-DESCRIPTION-DEC2020" and click on create cutomer button
    Then success message should be displayed and disappeared
    And user validates the message
    And logout from the application

  