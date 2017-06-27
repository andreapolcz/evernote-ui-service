Feature: Login functionality for users of Evernote

  Background:
    Given user is on Evernote Homepage

   @regression
  Scenario: Test login with valid credentials
    And he opens Header Menu
    And he clicks sign in button
    Then he is on login page
    And he enters his username "ndrplcz@gmail.com"
    And he hits the submit button
    And he enters his password "Letmein_123!"
    And he hits the submit button
    When opens user details by clicking on avatar icon
    Then displayed userName is "ndrplcz@gmail.com"
    And user logs out


  @regression
  Scenario: Test no credentials entered message
    And he opens Header Menu
    And he clicks sign in button
    And he is on login page
    And he hits the submit button
    Then "Required data missing" message is displayed
