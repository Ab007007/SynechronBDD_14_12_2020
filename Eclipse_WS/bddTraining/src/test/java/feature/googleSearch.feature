Feature: Google Search

  @smoke @google
  Scenario: Search for company
    Given user is on google page
    When user enters "Synechron" in search box
    And click on search button
    Then Google will display search results

    
    @sstest
  Scenario: Search for company
    Given user is on google page
    When user enters "Synechron" in search box
    And click on search button
    Then Google will display search results
    