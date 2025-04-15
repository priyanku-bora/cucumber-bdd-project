package com.demosite.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.demosite.stepdef","com.demosite.hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true) // Enable parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}