Feature: Validate search Reults

  Scenario: Search Scenario
    Given user is on google page
    When user enters 10 in search box
    And click on search button
    Then Google will display Exact (10 search results)
