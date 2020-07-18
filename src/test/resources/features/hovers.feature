Feature: HoversFeature

  Scenario: Hovers Test
    Given User visit the site home page "http://the-internet.herokuapp.com/"
    And  User clicks on the Hovers link provided
    And User hover on first Image  Icon available
    Then UserOne should appear on hover
