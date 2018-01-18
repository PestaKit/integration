Feature: Integration of Users and Surveys microservices

  Background:
    Given there is a Users server
    And there is a Surveys server



  #Scenario: I can create a user, get the token and create a question
   # Given I have a correct payload to create a user
    #When I POST it to the /users endpoint
    #Then I receive a 201 user API status code

 #1
  Scenario: I can't create a question without token
    Given I have a question with full payload
    When I POST it to the /questions endpoint
    Then I receive a 403 survey API status code

 #2
  Scenario: I can create a question if I have a token
    Given I have a question with full payload and a token
    When I POST it to the /questions endpoint
    Then I receive a 201 survey API status code