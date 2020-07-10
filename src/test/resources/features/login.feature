@complete
Feature: LoginFeature
  Scenario: Login test
    Given User is on site home page "http://the-internet.herokuapp.com/">
    When user clicks on the basic auth link provided
    And user enter the username as "admin" and password as "admin" and clicks on sign in button
    Then user should be logged in and navigated to page "http://the-internet.herokuapp.com/basic_auth"
