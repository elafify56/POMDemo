package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    // locators

    @FindBy(css = "input[id=\"small-searchterms\"]")
    private WebElement searchInput;

    @FindBy(css = "input[class=\"button-1 search-box-button\"]")
    private WebElement searchBtn;

    @FindBy(css = "input[class=\"button-2 product-box-add-to-cart-button\"]")
    private WebElement addToCartBtn;

    @FindBy(css = "span[class=\"cart-qty\"]")
    private WebElement cartQty;

    // actions

    public void search(String query){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(query);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }

    public void addToCart10Times() throws InterruptedException {

        for (int i = 0 ; i<10 ; i++){
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            Thread.sleep(300);
            addToCartBtn.click();
        }

    }

    public String returnCartQty(){
        wait.until(ExpectedConditions.visibilityOf(cartQty));
        return cartQty.getText();
    }


}
