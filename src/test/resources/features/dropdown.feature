Feature: CheckboxFeature

  Scenario: Dropdown Test
    Given User comes on site home page "http://the-internet.herokuapp.com/"
    And  User clicks on the Dropdown link provided
    And User select Dropdown icon and section first option
    Then first dropdown should be selected
