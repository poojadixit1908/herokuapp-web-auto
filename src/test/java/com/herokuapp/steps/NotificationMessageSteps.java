package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.MuliplewindowsPage;
import com.herokuapp.pageobjects.NotificationMessagePage;
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

public class NotificationMessageSteps {

    private static WebDriver webDriver;
    private static HomePage homePage;
    private static NotificationMessagePage notificationMessagePage;
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


    @Given("^User is on the home page \"([^\"]*)\"$")
    public void userIsOnTheHomePage(String url) {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        homePage.goToHomePage(url);
        notificationMessagePage = new NotificationMessagePage(webDriver);
        //verify that the current is home page
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("Should go to home page URL: http://the-internet.herokuapp.com/", url, currentPageUrl);

    }

    ;


    @And("^User clicks the Notification Message link provided$")
    public void userClicksTheNotificationMessageLinkProvided() {
        homePage.clickNotificationMessage();
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("The current page url should be : " +
                        "http://the-internet.herokuapp.com/notification_message_rendered",
                "http://the-internet.herokuapp.com/notification_message_rendered", currentPageUrl);


    }

    @And("^Text of the top notification message should be \"([^\"]*)\"$")
    public void textOfTheTopNotificationMessageShouldBe(String msg)  {
        String flashMessageBeforeClick = notificationMessagePage.getFlashMessage();
        Assert.assertTrue("The notification message should have been:  Action successful", flashMessageBeforeClick.contains("Action successful"));
    }

    @And("^user clicks on the click here tab$")
    public void userClicksOnTheClickHereTab() {
        notificationMessagePage.clickOnClickHereLink();
    }

    @Then("^The message should be \"([^\"]*)\"$")
    public void theMessageShouldBe(String msg)  {
        String flashMessageAfterClick = notificationMessagePage.getFlashMessage();
        Assert.assertTrue("The notification message should have been:  Action unsuccesful, please try again", flashMessageAfterClick.contains("Action unsuccesful, please try again"));
    }
}

