Feature: Create customer 
Scenario: Create Mulitple Customers
    Given User is loggedin to the actitime application using "admin" and "manager"
    When User click on tasks tab
    Then User is navigated to tasks page
    When User enters customername and customerdescription repeatedly to create mulitple customer
      | customername | customerdesc |
      | syn-BDD-DT1  | syn-Desc1    |
      | syn-BDD-DT2  | syn-DESC2    |
      | syn-BDD-DT3  | syn-DESC3    |
      | syn-BDD-DT4  | syn-DESC4    |
    And logout from the application
