Feature: Context Menu Feature

  Scenario: Context Menu Test based on the given parameter

    Given User is on our home page "http://the-internet.herokuapp.com/"
    When User clicks the context Menu link provided
    And User right click on the rectangular box present on context menu page
    And Pop up should appear with ok button and text should be "You selected a context menu"
    Then On clicking the ok button, pop up should be closed
