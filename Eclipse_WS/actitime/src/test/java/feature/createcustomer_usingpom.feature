Feature: Create customer using POM

Background:
	Given pomuser has browser object
	And actitime application is launched
	Then pomuser login to the application
	

@pom
Scenario: Create Customer using pom
	Given pomuser is on dashboard page
	When pomuser click on tasks tab
	And pomuser click on createNew customer button on taskspage
	Then Enter "POM-DEC-Cust6" 	and "POM-DEC-DESC-Cust6" respectively
	When pomuser click on create new customer button
	Then customer will be created successfully and success message is validated
	And pomuser logout of actitime