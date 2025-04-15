package com.demosite.pages;

import com.demosite.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public  WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email1']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password1']")
    WebElement passwordInput;

    @FindBy(css = ".submit-btn")
    WebElement signInButton;

    @FindBy(xpath = "//h2[@class='header']")
    public WebElement signInHeader;



    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }


    public boolean isLoginPage() {
        return  signInHeader.isDisplayed();
    }

    public void navigateToNewPage() {
        driver.get("https://freelance-learn-automation.vercel.app/login");
    }
}