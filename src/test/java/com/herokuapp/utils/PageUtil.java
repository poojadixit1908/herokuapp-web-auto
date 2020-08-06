package com.herokuapp.utils;

import org.openqa.selenium.WebDriver;

public class PageUtil {

    private WebDriver driver;

    public PageUtil(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }
}
