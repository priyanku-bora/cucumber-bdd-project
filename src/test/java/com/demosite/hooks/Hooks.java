package com.demosite.hooks;


import com.aventstack.extentreports.ExtentTest;
import com.demosite.utils.DriverManager;
import com.demosite.utils.ExtentManager;
import com.demosite.utils.ExtentTestManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        
        DriverManager.initDriver("firefox");

        ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
        ExtentTestManager.setTest(test);
        System.out.println("🚀 Starting Scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on failure");
            ExtentTestManager.getTest().fail("❌ Step failed. Screenshot attached.");
        } else {
            ExtentTestManager.getTest().pass("✅ Step passed");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("❌ Scenario failed: " + scenario.getName());
        } else {
            ExtentTestManager.getTest().pass("✅ Scenario passed: " + scenario.getName());
        }
        DriverManager.quitDriver();
    }

    @AfterAll
    public static void afterAll() {
        ExtentManager.getInstance().flush();
    }
}