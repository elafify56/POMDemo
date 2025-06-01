package com.automationexercise.base;

import com.automationexercise.factory.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.ExtentManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert soft;


    @BeforeMethod
    public void setup(Method method){
        driver = new DriverFactory().initDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        soft = new SoftAssert();
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }



}
