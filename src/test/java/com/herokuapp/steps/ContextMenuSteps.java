package com.herokuapp.steps;

import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.ContextMenuPage;
import com.herokuapp.pageobjects.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class ContextMenuSteps {

    private static WebDriver webDriver;
    private static HomePage homePage;
    private static ContextMenuPage contextMenuPage;

    @Before
    public void before() {
        webDriver = WebDriverProviderFactory.getBrowser();
    }
    @After
    public void after() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    @Given("^User is on our home page \"([^\"]*)\"$")
    public void userIsOnHomePage(String url) {
        contextMenuPage = new ContextMenuPage(webDriver);
        homePage= new HomePage(webDriver);
        homePage.goToHomePage(url);
    }

    @When("^User clicks the context Menu link provided$")
    public void userClicksTheContextMenuLinkProvided() {
        homePage.clickContextMenu();
    }

    @And("^User right click on the rectangular box present on context menu page$")
    public void userRightClickOnTheRectangularBoxPresentOnContextMenuPage() {
        contextMenuPage.rightClickOnBox();


    }

    @And("^Pop up should appear with ok button and text should be \"([^\"]*)\"$")
    public void popUpShouldAppearWithOkButtonAndTextShouldBe(String popupText) {
        String textOfPopUp = contextMenuPage.getTextOfPopUp();
        Assert.assertEquals("The alert msg should be: "+ popupText, popupText, textOfPopUp);
    }

    @Then("^On clicking the ok button, pop up should be closed$")
    public void onClickingTheOkButtonPopUpShouldBeClosed() throws InterruptedException {
        Thread.sleep(2000);
        contextMenuPage.clickOkButtonOnPopUp();
    }


}
