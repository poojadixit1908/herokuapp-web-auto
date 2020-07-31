package com.herokuapp.steps;

import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.HorizontalsliderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class HorizontalSliderStep {

    @Inject
    private WebDriver webDriver;

    private static HorizontalsliderPage horizontalsliderPage;
    private static HomePage homePage;

    @Given("^User visits the home page \"([^\"]*)\"$")
    public void userVisitsTheHomePage(String url) {
        horizontalsliderPage = new HorizontalsliderPage(webDriver);
        homePage = new HomePage(webDriver);
        horizontalsliderPage.goToHomePage(url);
    }

    @And("^User clicks the Horizontal Slider link provided$")
    public void userClicksTheHorizontalSliderLinkProvided() {
        homePage.clickHorizontalSlider();

    }


    @And("^User clicks the sliderbar with right arrow$")
    public void userClicksTheSliderbarWithRightArrow() throws InterruptedException {
        horizontalsliderPage.clickSliderBar();
    }

    @Then("^Range of the slider should change to \"([^\"]*)\"$")
    public void rangeOfTheSliderShouldChangeTo(String expectedRange) {
        String updatedSliderRange = horizontalsliderPage.getUpdatedSliderRange();
        Assert.assertEquals("Range of the slider bar should be: " + expectedRange, expectedRange, updatedSliderRange);
    }
}
