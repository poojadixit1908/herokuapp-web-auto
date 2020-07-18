package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {

    protected WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickFirstCheckbox() {
        WebElement formElement = driver.findElement(By.id("checkboxes"));
        List<WebElement> inputElements = formElement.findElements(By.tagName("input"));
        WebElement firstCheckbox = inputElements.get(0);
        firstCheckbox.click();
        return firstCheckbox;
    }
}
