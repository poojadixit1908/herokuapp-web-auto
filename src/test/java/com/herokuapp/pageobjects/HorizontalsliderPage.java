package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalsliderPage extends BasePage {
    public HorizontalsliderPage(WebDriver driver) {
        super(driver);
    }

    public void clickSliderBar() throws InterruptedException {

        WebElement slider = driver.findElement(By.className("sliderContainer"));
        WebElement inputElement = slider.findElement(By.tagName("input"));
        Actions action = new Actions(driver);
        action.click(inputElement).build().perform();
        action.sendKeys(Keys.ARROW_RIGHT).build().perform();
    }

    public String getUpdatedSliderRange() {
        WebElement rangeSpanElement = driver.findElement(By.id("range"));
        return rangeSpanElement.getText();
    }
}