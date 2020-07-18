package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.inject.Inject;
import java.util.List;

public class HoversPage {
    protected WebDriver driver;


    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public String hoverOnFirstUser() {
        WebElement exmapleDivElement = driver.findElement(By.className("example"));
        List<WebElement> figureElementsDivs = exmapleDivElement.findElements(By.className("figure"));// 3 divs
        WebElement firstFigureDivElement = figureElementsDivs.get(0);
        WebElement imgElement = firstFigureDivElement.findElement(By.tagName("img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(imgElement).perform();

        WebElement figCaptionElement = firstFigureDivElement.findElement(By.className("figcaption"));
        WebElement h5Element = figCaptionElement.findElement(By.tagName("h5"));
        String h5ElementText = h5Element.getText();
        return h5ElementText;
    }
}