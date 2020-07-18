package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotpasswordPage {
    protected WebDriver driver;

    public ForgotpasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void retrieveEmailViaForgotPassword() {
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.click();
        emailElement.sendKeys("abcde@gmail.com");
        WebElement submitButtonElement = driver.findElement(By.id("form_submit"));
        submitButtonElement.click();

    }
}
