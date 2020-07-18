Feature: Drag and drop Feature

  Scenario:  Drag and drop Test
    Given User goes on site home page "http://the-internet.herokuapp.com"
    And  User clicks on the drag and drop link provided
    And User drags the A component on the B component
    Then A component should become B and B should become A

