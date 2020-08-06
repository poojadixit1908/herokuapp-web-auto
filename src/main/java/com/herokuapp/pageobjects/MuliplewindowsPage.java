package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MuliplewindowsPage extends BasePage {

    public MuliplewindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnOpenNewWindow() {
        WebElement divClassElement = driver.findElement(By.className("example"));
        WebElement clickHereElement = divClassElement.findElement(By.tagName("a"));
        clickHereElement.click();

    }

}