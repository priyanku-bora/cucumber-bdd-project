package com.demosite.stepdef;

import com.demosite.pages.HomePage;
import com.demosite.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageStepDef {
    private WebDriver driver;
    private HomePage homePage;

    public HomePageStepDef(){
        this.driver = DriverManager.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Then("I should be navigated to the home page")
    public void validateHomePage(){
        Assert.assertTrue(homePage.isHomePage(),"Unable to navigate to Home Page");
    }
}
