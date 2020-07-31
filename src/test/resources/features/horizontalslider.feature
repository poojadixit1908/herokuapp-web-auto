Feature: Horizontal Slider Feature

  Scenario: Form Authentication Test based on the given parameter


    Given User visits the home page "http://the-internet.herokuapp.com/"
    And  User clicks the Horizontal Slider link provided
    And User clicks the sliderbar with right arrow
    Then Range of the slider should change to "3"