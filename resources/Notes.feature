Feature: Notes

  Gives the possibility to create numerous types of notes

  Background:
    Given user is on Evernote Homepage
    And he opens Header Menu
    And he clicks sign in button
    Then he is on login page
    And he enters his username "ndrplcz@gmail.com"
    And he hits the submit button
    And he enters his password "Letmein_123!"
    And he hits the submit button

  @regression
  Scenario: Create simple note, and check if it remains saved after loging in again
    And clicks new note button
    And put in note title "My newest 2 note"
    And hits button done
    And opens user details by clicking on avatar icon
    And user logs out
    Then he is on login page
    And he enters his username "ndrplcz@gmail.com"
    And he hits the submit button
    And he enters his password "Letmein_123!"
    And he hits the submit button
    And opens note "My newest 2 note" from notes list
    And deletes selected note
    When opens user details by clicking on avatar icon
    And user logs out

  @regression
  Scenario: Create a note that has a 3x3 matrix inside the notes body
    And clicks new note button
    And put in note title "My newest 2 note"
    And clicks button "tableButton" from insert elements in body header
    And selects a "3" by "3" table
    And verifies that there are "3" rows in generated table
    And verifies that there are "3" columns in a table of "3" rows
    And hits button done
    And opens note "My newest 2 note" from notes list
    And deletes selected note
    When opens user details by clicking on avatar icon
    And user logs out



