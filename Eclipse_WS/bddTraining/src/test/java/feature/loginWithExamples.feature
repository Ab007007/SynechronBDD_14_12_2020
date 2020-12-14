Feature: Validate login functionality

  Scenario Outline: Valid Login
    Given superuser is on login page
    When superuser enter <username> and <password>
    And click on loginbutton
    Then user should be able to see dashbord page or stay on loginpage

    Examples: 
      | username | password |
      | admin    | manager  |
      | admin1   | manager1 |
      | admin    | manager1 |
