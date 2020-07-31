

Feature: Form Authentication Feature

  Scenario: Form Authentication Test with Valid credential

    Given User is currently on the home page "http://the-internet.herokuapp.com/"
    And  User clicks the Form Authentication Message link provided
    When User enter valid username as "tomsmith" and password as "SuperSecretPassword!" and click on the login button
    Then Text of top notification message should be "You logged into a secure area!"



