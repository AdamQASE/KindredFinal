@wip
Feature: Edit Settings

  Background: User sign in
    Given the user is in home page
    When the user clicks sign in button
    And the user enters valid credentials
    And the user clicks sign in button

Scenario: User can edit settings
  Given the user is already signed in
  When the user clicks the settings button
  Then the user should navigate settings page
  When the user enters text in short bio about you box
  And the user clicks the update settings button
  Then the text should appear under the username