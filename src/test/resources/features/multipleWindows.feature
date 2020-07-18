Feature: Multiple Windows Feature

  Scenario: Multiple Windows Test

    Given User visit home page "http://the-internet.herokuapp.com/"
    And  User clicks the Multiple windows link provided
    Then user clicks on click here tab available on windows page
    Then new window should be opened
