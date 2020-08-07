# new feature
# Tags: optional
@sanity
Feature: WeatherFeature
  Scenario: Weather API test via longitude and latitude
    Given website user on site home page "http://the-internet.herokuapp.com/">
    When  User try to get the temperature of Delhi city via entering latitude "28.644800"and longitide "77.216721"
    Then  User should see the result correctly as per the api

