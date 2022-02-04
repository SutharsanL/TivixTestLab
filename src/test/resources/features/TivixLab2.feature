
Feature: Test the rental car web application with negative Scenarios


  @invaliddropoffdate
  Scenario: Valide by providing Invalid dropoff date
    Given I want to Select Country
    When I want to Select City
    And I want to enter the car model
    When I want to select valid pickup and invalid dropoff date
    Then I Validate the error message for dropdate

 @enterinvalidpersonalData
  Scenario: Enter valid personal Details
    Given I want to Select Country
    And I want to Select City
    And I want to enter the car model
    And Select Pickup date and Dropoff date
    When I click on Search button
    And I Click on Rent button
    And Click on Rent button in car Details Page
    And I want to enter invalid Data
    When I click Rent button in Summarypage
    Then I vaildate the error message
