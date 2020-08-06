package com.herokuapp.vo;

public class WeatherResponseData {

    private String conditionDesc;
    private double temp;

    public WeatherResponseData(String conditionDesc, double temp) {
        this.conditionDesc = conditionDesc;
        this.temp = temp;
    }

    public String getConditionDesc() {
        return conditionDesc;
    }

    public double getTemp() {
        return temp;
    }
}
