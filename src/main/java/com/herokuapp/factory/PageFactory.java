package com.herokuapp.factory;

import com.herokuapp.pageobjects.BasePage;
import com.herokuapp.pageobjects.CheckboxesPage;
import com.herokuapp.pageobjects.HomePage;
import com.herokuapp.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static BasePage createPage(String pageName, WebDriver driver){

        BasePage page = null;

        switch (pageName) {

            case "homePage":
              page = new HomePage(driver);
              break;
            case "loginPage":
              page = new LoginPage(driver);
              break;
            case "checkboxPage":
              page = new CheckboxesPage(driver);
              break;
        }
        return page;

    }

}

