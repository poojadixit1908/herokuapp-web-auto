package com.herokuapp.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickOnBox() {
        WebElement rectangularBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(rectangularBox).perform();


    }

    public String getTextOfPopUp() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

    public void clickOkButtonOnPopUp() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}


