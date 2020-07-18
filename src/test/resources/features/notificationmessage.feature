Feature: Notification Message Feature

  Scenario: Notification Message Test

    Given User is on the home page "http://the-internet.herokuapp.com/"
    And  User clicks the Notification Message link provided
    And Text of the top notification message should be "Action successful\nx"
    And user clicks on the click here tab
    Then The message should be "Action unsuccesful, please try again"