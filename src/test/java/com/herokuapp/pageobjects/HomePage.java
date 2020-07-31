package com.herokuapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void goToAbTestingModule() {
        WebElement abElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a"));
        abElement.click();
    }


    public void clickOnCheckboxesLink() {

        clickOnSubModule("Checkboxes");

    }

    public void clickOnFormAuthenticationLink() {
        clickOnSubModule("Form Authentication");
    }

    public void clickDropdownLink() {
        clickOnSubModule("Dropdown");
    }

    public void clickHoversLink() {
        clickOnSubModule("Hovers");
    }

    public void clickForgotPasswordLink() {
        clickOnSubModule("Forgot Password");
    }

    public void clickDragDropLink() {
        clickOnSubModule("Drag and Drop");
    }

    public void clickMultipleWindowsLink() {
        clickOnSubModule("Multiple Windows");
    }

    public void clickNotificationMessage() {
        clickOnSubModule("Notification Messages");
    }

    public void clickHorizontalSlider(){
        clickOnSubModule("Horizontal Slider");
    }


    private void clickOnSubModule(String moduleName) {
        WebElement contentDivElement = driver.findElement(By.id("content"));
        WebElement ulElement = contentDivElement.findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));//42 elements
        for (WebElement liElement : liElements) {
            String hrefValue = liElement.getText(); //should be Checkboxes
            if (moduleName.equals(hrefValue)) {
                liElement.findElement(By.tagName("a")).click();
                break;
            }
        }
    }


}


