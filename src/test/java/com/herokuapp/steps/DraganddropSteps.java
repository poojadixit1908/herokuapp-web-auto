package com.herokuapp.steps;

import com.herokuapp.pageobjects.DraganddropPage;
import com.herokuapp.pageobjects.DropdownPage;
import com.herokuapp.pageobjects.ForgotpasswordPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.utils.PageUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class DraganddropSteps {
    @Inject
    private WebDriver webDriver;
    private static HomePage homePage;
    private static DraganddropPage dragdropPage;
    private static PageUtil pageUtil;

    @Given("^User goes on site home page \"([^\"]*)\"$")
    public void userGoesOnSiteHomePage(String url)  {
        homePage = new HomePage(webDriver);
        pageUtil = new PageUtil(webDriver);
        dragdropPage=new DraganddropPage(webDriver);
        homePage.goToHomePage(url);


    }

    @And("^User clicks on the drag and drop link provided$")
    public void userClicksOnTheDragAndDropLinkProvided() {
        homePage.clickDragDropLink();
    }

    @And("^User drags the A component on the B component$")
    public void userDragsTheAComponentOnTheBComponent() {
        dragdropPage.dragandDropTheComponents();
    }

    @Then("^A component should become B and B should become A$")
    public void aComponentShouldBecomeBAndBShouldBecomeA() {

    }
}
