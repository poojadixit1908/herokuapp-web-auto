# new feature
# Tags: optional
Feature: CheckboxFeature

  Scenario: Checkbox Test
    Given User is on site home page "http://the-internet.herokuapp.com/"
    And  User clicks on the checkboxes link provided
    And User select first checkbox
    Then first checkbox should be selected
