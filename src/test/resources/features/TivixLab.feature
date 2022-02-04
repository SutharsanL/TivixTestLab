
Feature: Test the rental car web application with positive Scenarios
 
  Background: Search cars for specific Country/City
 Given I want to Select Country
    When I want to Select City
    And I want to enter the car model
    And Select Pickup date and Dropoff date
    When I click on Search button
 
  @validatecardetails
  Scenario: validate the car details by Clicking Rent button
    Given I validate wheather rental cars were displayed
    When I Click on Rent button
    Then I Validate the Car details
    
   @entervalidpersonalData
  Scenario: Enter valid personal Details
    Given I Click on Rent button
    And Click on Rent button in car Details Page
    And I want to enter valid Data
    When I click Rent button in Summarypage
    Then I vaildate whether application is working as expected
