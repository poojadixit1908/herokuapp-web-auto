package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownPage {

    protected WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickOption1dropdown() {
        WebElement selectedOptionElement = null;
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        List<WebElement> optionElements = dropdownElement.findElements(By.tagName("option"));//3 elements
        for (WebElement optionElement : optionElements) {
            String optionText = optionElement.getText();//Option 1, Option 2 etc
            if (optionText.equals("Option 1")) {
                optionElement.click();
                selectedOptionElement = optionElement;
                break;
            }
        }
        return selectedOptionElement;
    }


}

