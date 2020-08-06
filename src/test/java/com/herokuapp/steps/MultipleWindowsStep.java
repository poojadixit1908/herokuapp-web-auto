package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.CheckboxesPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.MuliplewindowsPage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowsStep {

    private static WebDriver webDriver;
    private static HomePage homePage;
    private static MuliplewindowsPage muliplewindowsPage;
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



    @Given("^User visit home page \"([^\"]*)\"$")
    public void userVisitHomePage(String url) {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        homePage.goToHomePage(url);
        muliplewindowsPage = new MuliplewindowsPage(webDriver);
        //verify that the current is home page
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("Should go to home page URL: http://the-internet.herokuapp.com/", url, currentPageUrl);

    }

    @And("^User clicks the Multiple windows link provided$")
    public void userClicksTheMultipleWindowsLinkProvided() {
        homePage.clickMultipleWindowsLink();
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("The current page should be: http://the-internet.herokuapp.com/windows",
                "http://the-internet.herokuapp.com/windows", currentPageUrl);

    }


    @Then("^user clicks on click here tab available on windows page$")
    public void userClicksOnTabAvailableOnWindowsPage(){
        muliplewindowsPage.clickOnOpenNewWindow();
        List<String> browserTabs = new ArrayList<String>(webDriver.getWindowHandles());
        //switch to new tab
        webDriver.switchTo().window(browserTabs.get(1));
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("Should go to home page URL: http://the-internet.herokuapp.com/windows/new", "http://the-internet.herokuapp.com/windows/new", currentPageUrl);
        Assert.assertEquals("", "New Window", pageUtil.getCurrentPageTitle());

    }
    @Then("^new window should be opened$")
    public void newWindowShouldBeOpened() {

    }
}
