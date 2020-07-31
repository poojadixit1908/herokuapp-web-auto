package com.herokuapp.steps;

import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.UrlChecker;

import javax.inject.Inject;

public class FormAuthenticationSteps {

    @Inject
    private WebDriver webDriver;

    private static HomePage homePage;
    private static LoginPage loginPage;

    @Given("^User is currently on the home page \"([^\"]*)\"$")
    public void userIsCurrentlyOnTheHomePage(String url) {
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage.goToHomePage(url);
    }

    @And("^User clicks the Form Authentication Message link provided$")
    public void userClicksTheFormAuthenticationMessageLinkProvided() {
        homePage.clickOnFormAuthenticationLink();
    }

    @When("^User enter valid username as \"([^\"]*)\" and password as \"([^\"]*)\" and click on the login button$")
    public void userEnterValidAndAndClickOnTheLoginButton(String username, String password) {
        loginPage.login(username, password);

    }

    @Then("^Text of top notification message should be \"([^\"]*)\"$")
    public void textOfTopNotificationMessageShouldBe(String notificationMsg) {
        String topMessageText = loginPage.getTopMessageTextOnLogin();


        Assert.assertTrue("text message should be: You logged into a secure area!",
                topMessageText.contains(notificationMsg));

    }


    @And("^User clicks the Form Authentication Message link provided on home page$")
    public void userClicksTheFormAuthenticationMessageLinkProvidedOnHomePage() {
        homePage.clickOnFormAuthenticationLink();
    }

    @When("^user enter invalid username \"([^\"]*)\" and password as \"([^\"]*)\" and click on the login button$")
    public void userEnterInvalidUsernameAndPasswordAsAndClickOnTheLoginButton(String username, String password) {
        loginPage.login(username, password);
    }


    @Then("^text of the notification message on top should be \"([^\"]*)\"$")
    public void textOfTheNotificationMessageOnTopShouldBe(String notificationMessage) {
        String topMessageTextOnLoginWithInvalidUsername = loginPage.getTopMessageTextOnLogin();

        Assert.assertTrue("text message should be:  Your username is invalid!",
                topMessageTextOnLoginWithInvalidUsername.contains(notificationMessage));
    }

}


