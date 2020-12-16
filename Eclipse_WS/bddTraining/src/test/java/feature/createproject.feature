@shyamoli
Feature: Create and delete project

Background: Driver initialization and login
Given User initiates the browser and launches the "http://localhost/login.do" url
When User enters "admin" and "manager" as valid credentials
Then User is successfully logged in to the application



Scenario: Create project
Given  User is on landing page 
And User clicks on Tasks option
When User clicks on Addnew and AddnewProject buttons
And User is on the CreateNewProjectPage
And User enters "Syn-Project1-BDD3" and "syn-BDD-DT1" and "Syn-Project-BDD_desc3" 
And User clicks on CreateProjectButton
Then User has successfully created a project
And User logsOut of the application

Scenario: Delete project
Given User is on landing page 
And User clicks on Tasks option
When User searches  "Syn-Project-BDD3" in the search box
And User moves to the gearbox in the "Syn-Project1-BDD3" result and clicks on the gear box
And User clicks on the Actions button followed by delete button
And User clicks on delete button
Then User has successfully deleted the project
And User logsOut of the application


