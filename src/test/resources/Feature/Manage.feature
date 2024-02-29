@tag
Feature: OpenMRS Manage
  I want to use this template for my manage functionality

  @tag1
  Scenario: Manage OpenMRS
    Given Browser is open
    And Browser is on the login page
    When i enter username and password
    When i click on impatient ward to access location
    Then i navigate to homepage

  Scenario: Manage OpenMRS website
    Given website is opened
    And naviagate to login page
    When user enter username and password
    When user click on impatient ward to access location
    Then user navigate to homepage
