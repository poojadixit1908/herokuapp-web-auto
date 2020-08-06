package com.herokuapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Child extends Parent {


    public Child(int val) {
        super(val);
    }



    public static void main(String[] args) {
        Child c = new Child(10);
    }


}


