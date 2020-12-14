Feature: Google Search 

Scenario: Search for company
	Given user is on google page
	When user enters Synechron in search box
	And click on search button
	Then Google will display search results