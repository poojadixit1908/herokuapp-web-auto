package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage(String homePageUrl) {
        driver.get(homePageUrl);
    }

    public void goToAbTestingModule() {
        WebElement abElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a"));
        abElement.click();
    }

}

