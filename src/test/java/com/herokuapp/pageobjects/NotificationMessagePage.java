package com.herokuapp.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationMessagePage {
    protected WebDriver driver;

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnClickHereLink() {
        WebElement divClassElement = driver.findElement(By.className("example"));
        WebElement clickHereElement = divClassElement.findElement(By.tagName("a"));
        clickHereElement.click();
    }

    public String getFlashMessage() {
        WebElement flashMsgElement = driver.findElement(By.id("flash-messages"));
        return flashMsgElement.getText();
    }

}


