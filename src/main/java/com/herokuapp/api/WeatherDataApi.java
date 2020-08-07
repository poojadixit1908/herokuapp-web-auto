package com.herokuapp.api;

import com.herokuapp.vo.WeatherResponseData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.weatherbit.io/api/swaggerui/weather-api-v2
 */

public class WeatherDataApi {

    private static String API_BASE_URL = "http://api.weatherbit.io/v2.0/";
    private static String API_KEY = "223bfae5d2c64aa5a0488a63fd90cf64";


    public static WeatherResponseData getWeatherDataByCountryAndCity(String countryCode, String city) {

        RestAssured.baseURI = API_BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        String apiUrl = "/current?city=" + city + "&country=" + countryCode + "&key=" + API_KEY;
        Response response = httpRequest.request(Method.GET, apiUrl);
        HashMap dataMap = (HashMap) response.getBody().jsonPath().getList("data").get(0);
        String temp = (String) dataMap.get("temp");
        String condition = ((HashMap) dataMap.get("weather")).get("description").toString();

        WeatherResponseData weatherResponseData = new WeatherResponseData(condition, temp);
        return weatherResponseData;
    }

    /**
     * https://www.weatherbit.io/api/swaggerui/weather-api-v2#!/Current32Weather32Data/get_current_lat_lat_lon_lon
     *
     * @param longitude
     * @param Latitude
     * @return
     */
    public static WeatherResponseData getWeatherDtaByLongAndLat(Double longitude, Double Latitude) {

        RestAssured.baseURI = API_BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        String apiUrl = "/current?lat=" + longitude + "&lon=" + Latitude + "&key=" + API_KEY;
        Response response = httpRequest.request(Method.GET, apiUrl);
        response.getBody();
        //get the 'data' map attribute from the response object
        Map dataValueMap = (Map) ((List) response.jsonPath().get("data")).get(0);
        String temp = dataValueMap.get("temp").toString();
        Map weatherMap = (Map) dataValueMap.get("weather");
        String description = (String) weatherMap.get("description");
        WeatherResponseData weatherResponseData = new WeatherResponseData(description, temp);
        return weatherResponseData;
    }

}
