package com.herokuapp.steps;

import com.herokuapp.api.WeatherDataApi;
import com.herokuapp.factory.WebDriverProviderFactory;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.vo.WeatherResponseData;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WeatherAPISteps {

    private static WebDriver webDriver;
    private static HomePage homePage;


    @Before
    public void before() {
        webDriver = WebDriverProviderFactory.getBrowser();
    }
    @After
    public void after() {
        webDriver.close();
        webDriver.quit();
    }


    @Given("^user is on site home page \"([^\"]*)\">$")
    public void userIsOnSiteHomePage(String url) {
        homePage = new HomePage(webDriver);
        homePage.goToHomePage(url);

    }


    @When("^user view the weather widget on the page$")
    public void userViewTheWeatherWidgetOnThePage() {

    }


    @Then("^the user for country Australia \"([^\"]*)\" and city \"([^\"]*)\" should see the result correctly as per the api$")
    public void theUserForCountryAustraliaAndCityShouldSeeTheResultCorrectlyAsPerTheApi(String countryCode, String city) {
        WeatherResponseData weatherByCountryAndCityFromPage = homePage.getWeatherByCountryAndCity();
        WeatherResponseData weatherDataByCountryAndCityFromApi = WeatherDataApi.getWeatherDataByCountryAndCity(countryCode, city);

        System.out.println("kdfjdk");

    }
}
