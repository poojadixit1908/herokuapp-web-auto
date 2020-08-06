package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.CheckboxesPage;
import com.herokuapp.pageobjects.DropdownPage;
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

import javax.inject.Inject;

public class DropdownStep {
    private static WebDriver webDriver;

    private static HomePage homePage;
    private static DropdownPage dropdownPage;
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
    @Given("^User comes on site home page \"([^\"]*)\"$")
    public void userIsOnSiteHomePage(String url) {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        dropdownPage = new DropdownPage(webDriver);
        homePage.goToHomePage(url);
    }
    @And("^User clicks on the Dropdown link provided$")
    public void userClicksOnTheDropdownLinkProvided() {
        homePage.clickDropdownLink();
    }

    @And("^User select Dropdown icon and section first option$")
    public void userSelectDropdownIconAndSectionFirstOption() {
        WebElement someElement = dropdownPage.clickOption1dropdown();
        Assert.assertEquals("Value 1 should have been selected", "1", someElement.getAttribute("value"));
        Assert.assertTrue("Option 1 element should have been selected", someElement.isSelected());
    }

    @Then("^first dropdown should be selected$")
    public void firstDropdownShouldBeSelected() {
    }
}
