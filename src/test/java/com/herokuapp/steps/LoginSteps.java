package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginSteps {

    private static WebDriver webDriver;

    private static HomePage homePage;


    @Before
    public void before() {
        webDriver = WebDriverProviderFactory.getBrowser();
    }

    @After
    public void after() {
        webDriver.close();
        webDriver.quit();
    }


    @Given("^User is on site home page \"([^\"]*)\">$")
    public void userIsOnSiteHomePage(String url) {
        homePage = new HomePage(webDriver);
        homePage.goToHomePage(url);
    }

    @When("^user clicks on the basic auth link provided$")
    public void userClicksOnTheBasicAuthLinkProvided() {
    }

    @And("^user enter the username as \"([^\"]*)\" and password as \"([^\"]*)\" and clicks on sign in button$")
    public void userEnterTheUsernameAsAndPasswordAsAndClicksOnSignInButton(String username, String password) throws Throwable {

    }

    @Then("^user should be logged in and navigated to page \"([^\"]*)\"$")
    public void userShouldBeLoggedInAndNavigatedToPage(String successPageUrl) throws Throwable {

    }


    @And("^user clicks on the checkboxes link provided$")
    public void userClicksOnTheCheckboxesLinkProvided() {
    }
}
