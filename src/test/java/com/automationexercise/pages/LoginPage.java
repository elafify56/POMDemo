package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // locators

    @FindBy(css = "a[class=\"ico-login\"]")
    private WebElement loginLink;

    @FindBy(css = "input[id=\"Email\"]")
    private WebElement emailInput;

    @FindBy(css = "[id=\"Password\"]")
    private WebElement passwordInput;

    @FindBy(css = "input[class=\"button-1 login-button\"]")
    private WebElement loginBtn;

    @FindBy(css = "div[class=\"header-links\"] a[class=\"account\"]")
    private WebElement customerInfo;

    // actions

    public void goToLoginPage(){
        click(loginLink);
    }

    public void fillLoginForm(String email , String password){

        clearAndWrite(emailInput,email);
        clearAndWrite(passwordInput,password);
        click(loginBtn);
    }

    public boolean isLoggedIn(){
        return eleIsDisplayed(customerInfo);
    }


}
