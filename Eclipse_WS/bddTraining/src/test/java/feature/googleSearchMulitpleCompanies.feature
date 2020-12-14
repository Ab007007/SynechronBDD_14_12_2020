Feature: Google Search with multiple users

  Scenario: Search for company Synechron
    Given user is on google page
    When user enters "Synechron" in search box
    And click on search button
    Then Google will display search results
    
    
    
    Scenario: Search for company IBM
    Given user is on google page
    When user enters "IBM" in search box
    And click on search button
    Then Google will display search results
    
    
    Scenario: Search for company Wipro
    Given user is on google page
    When user enters "Wipro" in search box
    And click on search button
    Then Google will display search results

  