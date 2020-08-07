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

public class WeatherAPIWithLongLatSteps {




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


        @Given("^website user on site home page \"([^\"]*)\">$")
    public void websiteUserOnSiteHomePage(String url)  {
            homePage = new HomePage(webDriver);
            homePage.goToHomePage(url);

    }

    @When("^User try to get the temperature of Delhi city via entering latitude \"([^\"]*)\"and longitide \"([^\"]*)\"$")
    public void userTryToGetTheTemperatureOfDelhiCityViaEnteringLatitudeAndLongitide(double longitude, double latitude) {
     WeatherResponseData weatherResponseDataFromPage  = homePage.getWeatherByLongAndLat();
        WeatherResponseData weatherResponseDataFromAPI =WeatherDataApi.getWeatherDtaByLongAndLat(longitude, latitude);
        Assert.assertEquals("Condition description on the page doesn't match that from that on the page",weatherResponseDataFromAPI.getConditionDesc(),
                weatherResponseDataFromPage.getConditionDesc());
        Assert.assertEquals("", weatherResponseDataFromAPI.getTemp(), weatherResponseDataFromPage.getTemp());

    }

    @Then("^User should see the result correctly as per the api$")
    public void userShouldSeeTheResultCorrectlyAsPerTheApi() {
    }
}
