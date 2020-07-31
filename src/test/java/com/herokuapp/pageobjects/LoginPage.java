package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.click();
        userNameElement.sendKeys(user);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(pass);
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

    }

    public String getTopMessageTextOnLogin() {
        WebElement flashMessageDiv = driver.findElement(By.id("flash-messages"));
        String flashMessageDivText = flashMessageDiv.getText();
        return flashMessageDivText;


    }
}