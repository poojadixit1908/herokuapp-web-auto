# new feature
# Tags: optional

Feature: WeatherFeature

  Scenario: Weather API test
    Given user is on site home page "http://the-internet.herokuapp.com/">
    When user view the weather widget on the page
    Then the user for country Australia "AU" and city "Sydney" should see the result correctly as per the api
