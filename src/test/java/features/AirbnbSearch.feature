Feature: Airbnb Search Functionality

Background:
Given User launches the Airbnb application

Scenario: Verify user can search for steps in a city
When User enters location 
And User selects check-in and check-out dates
And User clicks on Search button
Then Search results page should be displayed