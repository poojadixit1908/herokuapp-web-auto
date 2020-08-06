package com.herokuapp.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.herokuapp"},
        features = ".",
        format = {"pretty", "html:target/cucumber-reports"},
        tags = {"@sanity"}
)
public class AllTests {
}