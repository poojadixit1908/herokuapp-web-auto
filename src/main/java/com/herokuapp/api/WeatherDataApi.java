package com.herokuapp.api;

import com.herokuapp.vo.WeatherResponseData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class WeatherDataApi {

    private static String API_BASE_URL = "http://api.weatherbit.io/v2.0/";
    private static String API_KEY = "223bfae5d2c64aa5a0488a63fd90cf64";

    public static WeatherResponseData getWeatherDataByCountryAndCity(String countryCode, String city) {

        RestAssured.baseURI = API_BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        String apiUrl = "/current?city=" + city + "&country=" + countryCode + "&key=" + API_KEY;
        Response response = httpRequest.request(Method.GET, apiUrl);
        HashMap dataMap = (HashMap) response.getBody().jsonPath().getList("data").get(0);
        float temp = (float)dataMap.get("temp");
        Double temperature = (double) temp;
        String condition = ((HashMap)dataMap.get("weather")).get("description").toString();

        WeatherResponseData weatherResponseData = new WeatherResponseData(condition, temperature);
        return weatherResponseData;
    }


}
