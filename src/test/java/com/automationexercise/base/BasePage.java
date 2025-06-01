package com.automationexercise.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void click(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    }

    public void clearAndWrite(WebElement ele , String word){
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.clear();
        ele.sendKeys(word);
    }

    public boolean eleIsDisplayed(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
        return ele.isDisplayed();
    }
}
