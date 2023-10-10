package com.api.testautomation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Copy this and place in Child Framework for TestNG Based Concurrent Execution
 * This Runner has the capability to execute the Scenarios In Parallel
 */
@CucumberOptions(
        features = {
                "classpath:features"
                //"C:\\Users\\jsnim\\IdeaProjects\\apiGovTech-UI-API-Merge\\src\\test\\resources\\features\\US4_createWorkingClassAPIwithVouchers.feature"
        },
        glue = {
                "com.api.testautomation.stepdefs"

        },
       //  tags = "@OppenHeimer",
        dryRun = false, monochrome = true,
        plugin = {"pretty",

                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunIT extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}