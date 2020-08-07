package com.herokuapp.vo;

public class WeatherResponseData {

    private String conditionDesc;
    private String temp;

    public WeatherResponseData(String conditionDesc, String temp) {
        this.conditionDesc = conditionDesc;
        this.temp = temp;
    }

    public String getConditionDesc() {
        return conditionDesc;
    }

    public String  getTemp() {
        return temp;
    }
}
