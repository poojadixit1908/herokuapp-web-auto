package com.herokuapp.utils;

import com.herokuapp.hooks.Hooks;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

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
