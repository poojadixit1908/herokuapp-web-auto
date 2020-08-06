package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.CheckboxesPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesStep {

    private WebDriver webDriver;

    private static HomePage homePage;
    private static CheckboxesPage checkboxesPage;
    private static PageUtil pageUtil;

    @Before
    public void before() {
        webDriver = WebDriverProviderFactory.getBrowser();
    }
    @After
    public void after() {
        webDriver.close();
        webDriver.quit();
    }

    @Given("^User is on site home page \"([^\"]*)\"$")
    public void userIsOnSiteHomePage(String url) {
        checkboxesPage = new CheckboxesPage(webDriver);
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
        WebElement selectedCheckbox = checkboxesPage.clickFirstCheckbox();
        //verify that the first checkbox has been selected
        Assert.assertTrue("checkbox 1 should be selected", selectedCheckbox.isSelected());
    }

    @Then("^first checkbox should be selected$")
    public void firstCheckboxShouldBeSelected() {
    }
}
