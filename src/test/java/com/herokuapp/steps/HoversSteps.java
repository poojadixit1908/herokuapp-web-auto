package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.DropdownPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.HoversPage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;

public class HoversSteps {


    private static WebDriver webDriver;
    private static HomePage homePage;
    private static HoversPage hoverPage;
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

    @Given("^User visit the site home page \"([^\"]*)\"$")
    public void userVisitTheSiteHomePage(String url) throws Throwable {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        hoverPage = new HoversPage(webDriver);
        homePage.goToHomePage(url);
    }

    @And("^User clicks on the Hovers link provided$")
    public void userClicksOnTheHoversLinkProvided() {
        homePage.clickHoversLink();
        //verify that the navigated page is hovers page
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("Should go to home page URL: http://the-internet.herokuapp.com/hovers", "http://the-internet.herokuapp.com/hovers", currentPageUrl);
    }

    @And("^User hover on first Image  Icon available$")
    public void userHoverOnFirstImageIconAvailable() {
        String userHovered = hoverPage.hoverOnFirstUser();
        Assert.assertEquals("The hovered user should be: name: user1", "name: user1", userHovered);
    }

    @Then("^UserOne should appear on hover$")
    public void useroneShouldAppearOnHover() {
    }
}
