Feature: Create customer 
Scenario: Create Mulitple Customers
    #Given User is loggedin to the actitime application using "admin" and "manager"
    When User click on tasks tab
    Then User is navigated to tasks page
    When User enters customername and customerdescription repeatedly as list to create mulitple customer
      | syn-ListBDD-DT1  | syn-Desc1    |
      | syn-ListBDD-DT2  | syn-DESC2    |
      | syn-ListBDD-DT3  | syn-DESC3    |
      | syn-ListBDD-DT4  | syn-DESC4    |
    And logout from the application
