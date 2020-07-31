

Feature: Form Authentication Feature

  Scenario: Form Authentication Test with Invalid credential

      Given User is currently on the home page "http://the-internet.herokuapp.com/"
      And  User clicks the Form Authentication Message link provided on home page
      When user enter invalid username "abcd" and password as "SuperSecretPassword!" and click on the login button
      Then text of the notification message on top should be "Your username is invalid!"

