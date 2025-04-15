package com.demosite.stepdef;

import com.demosite.pages.HomePage;
import com.demosite.pages.LoginPage;
import com.demosite.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageStepDef  {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginPageStepDef(){
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
    }


    @Given("I am on the login page of the application")
    public void navigateToLoginPage(){
        loginPage.navigateToNewPage();
    }

    @Given("I have entered the username as {string}")
    public void enterUsername(String username){
        loginPage.enterUsername(username);
    }

    @And("I have entered the password as {string}")
    public void enterPassword(String password){
        loginPage.enterPassword(password);
    }

    @When("I click on the Sign In button")
    public void clickSignInButton(){
        loginPage.clickSignInButton();
    }

    @Then("I am still on sign in page")
    public void validateSignInPage(){
        Assert.assertTrue(loginPage.isLoginPage());
    }
}
