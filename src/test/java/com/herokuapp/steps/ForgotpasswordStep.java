package com.herokuapp.steps;

import com.herokuapp.pageobjects.ForgotpasswordPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.HoversPage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class ForgotpasswordStep {


    @Inject
    private WebDriver webDriver;
    private static HomePage homePage;
    private static ForgotpasswordPage forgotpasswordPage;
    private static PageUtil pageUtil;

    @Given("^User visits the site home page \"([^\"]*)\"$")
    public void userVisitTheSiteHomePage(String url) {
        forgotpasswordPage = new ForgotpasswordPage(webDriver);
        homePage.goToHomePage(url);
    }


    @And("^User clicks on the forgotpassword link provided$")
    public void userClicksOnTheForgotpasswordLinkProvided() {
        homePage.clickForgotPasswordLink();
    }

    @And("^User enters the emailid and clicks the retrieve password$")
    public void userEntersTheEmailidAndClicksTheRetrievePassword(String emailId) {
        forgotpasswordPage.retrieveEmailViaForgotPassword();
    }

    @Then("^UserOne should be navigated on email sent link: \"([^\"]*)\"$")
    public void useroneShouldBeNavigatedOnEmailSentLink(String link) {
        String currentPageUrl = pageUtil.getCurrentPageUrl();
        Assert.assertEquals("current url should be : http://the-internet.herokuapp.com/email_sent", link, currentPageUrl);
    }


}
