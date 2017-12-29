Feature: Integration of Users and Surveys microservices

  Background:
    Given there is a Users server
    And there is a Surveys server


   #1
  Scenario: I can create a user
    Given I have a correct payload to create a user
    When I POST it to the /users endpoint
    Then I receive a 201 user API status code