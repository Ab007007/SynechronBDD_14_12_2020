Feature: Create customer

  Scenario: Create Mulitple Customers
    Given User is loggedin to the actitime application using "admin" and "manager"
    When User click on tasks tab
    Then User is navigated to tasks page
    When User enters customername and customerdescription as mapdata
      | customername   | customerdesc |
      | syn-MAPBDD-DT1 | syn-Desc1    |
    And logout from the application

 # Scenario: Create Mulitple Customers
  #  Given User is loggedin to the actitime application using "admin" and "manager"
   # When User click on tasks tab
    #Then User is navigated to tasks page
    #When User enters customername and customerdescription as listdata
     # | syn-LISTBDD-DT11 | syn-Desc1 |
    #And logout from the application
