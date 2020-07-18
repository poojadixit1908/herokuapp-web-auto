package com.herokuapp.steps;

import com.herokuapp.pageobjects.CheckboxesPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;

public class CheckboxesStep {
    @Inject
    private WebDriver webDriver;

    private static HomePage homePage;
    private static CheckboxesPage checkboxesPage;
    private static PageUtil pageUtil;

    @Given("^User is on site home page \"([^\"]*)\"$")
    public void userIsOnSiteHomePage(String url) {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        homePage.goToHomePage(url);
        //verify that the current is home page
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("Should go to home page URL: http://the-internet.herokuapp.com/", url, currentPageUrl);
    }

    @And("^User clicks on the checkboxes link provided$")
    public void userClicksOnTheCheckboxesLinkProvided() {
        homePage.clickOnCheckboxesLink();
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("The current page should be: http://the-internet.herokuapp.com/checkboxes", "http://the-internet.herokuapp.com/checkboxes", currentPageUrl);
    }

    @And("^User select first checkbox$")
    public void userSelectFirstCheckbox() {
        checkboxesPage = new CheckboxesPage(webDriver);
        WebElement selectedCheckbox = checkboxesPage.clickFirstCheckbox();
        //verify that the first checkbox has been selected
        Assert.assertTrue("checkbox 1 should be selected", selectedCheckbox.isSelected());
    }

    @Then("^first checkbox should be selected$")
    public void firstCheckboxShouldBeSelected() {
    }
}
