@wip
Feature: Users should be able to sign in
    #positive
  Scenario: User can sign in
    Given the user is in home page
    When the user clicks sign in button
    And the user enters valid credentials
    And the user clicks sign in button
    Then the user should be able to sign in
    #negative
   Scenario: User can't sign in
     Given the user is in home page
     When the user clicks sign in button
     When the user enters invalid credentials
     And the user clicks sign in button
     Then the user should not be able to sign in



