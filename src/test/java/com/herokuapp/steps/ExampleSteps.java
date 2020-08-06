package com.herokuapp.steps;

import javax.inject.Inject;

import com.herokuapp.factory.WebDriverProviderFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class ExampleSteps {

    private static WebDriver webDriver;

    @Before
    public void before() {
        webDriver = WebDriverProviderFactory.getBrowser();
    }
    @After
    public void after() {
        webDriver.close();
        webDriver.quit();
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) {
        System.out.println("2");
    }

    @Then("^I google should show me results!$")
    public void i_google_should_show_me_results() {
    }

}