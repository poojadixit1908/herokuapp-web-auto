Feature: forgotpassword Feature

  Scenario: Forgotpassword Test
    Given User visits the site home page "http://the-internet.herokuapp.com"
    And  User clicks on the forgotpassword link provided
    And User enters the emailid and clicks the retrieve password
    Then UserOne should be navigated on email sent link: "http://the-internet.herokuapp.com/email_sent"
