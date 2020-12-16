
Feature: Create customer 
Scenario: Create Mulitple Customers
   # Given User is loggedin to the actitime application using "admin" and "manager"
    When User click on tasks tab
    Then User is navigated to tasks page
    When User enters customername and customerdescription repeatedly to create mulitple customer
      | customername | customerdesc |
      | syn1-BDD-DT1  | syn-Desc1    |
      | syn1-BDD-DT2  | syn-DESC2    |
      | syn1-BDD-DT3  | syn-DESC3    |
      | syn1-BDD-DT4  | syn-DESC4    |
    And logout from the application
