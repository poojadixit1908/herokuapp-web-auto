package com.herokuapp.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraganddropPage {

    protected WebDriver driver;

    public DraganddropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void dragandDropTheComponents(){

        driver.manage().window().maximize();

        WebElement componentA = driver.findElement(By.id("column-a"));
        WebElement componentB = driver.findElement(By.id("column-b"));
        componentB.sendKeys(Keys.DOWN);
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(componentA)
                .moveToElement(componentB)
                .release(componentA)
                .build();

        dragAndDrop.perform();


    }
}
