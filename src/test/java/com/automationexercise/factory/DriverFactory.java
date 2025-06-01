package com.automationexercise.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(){
        tlDriver.set(new ChromeDriver());
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }

}
