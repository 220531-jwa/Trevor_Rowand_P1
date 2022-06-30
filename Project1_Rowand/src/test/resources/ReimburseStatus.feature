#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Changing Status of Reimburse

            Background: 
                Given a Finance Manager is on the Reimburse Page
                
           Scenario Outline: A Finanace Manager can approve or reject any Form
                When the Finance Manager clicks the Approve or Reject button
                Then the Form is approved or rejected
                And
                Then The cost of the Form is added back or finalized for the appropriate employee
