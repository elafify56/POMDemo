package com.automationexercise.testcases;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class ProductQuantityTest extends BaseTest {

    private String query = "14.1-inch Laptop";

    @Test
    public void shouldBeAbleToReadQty() throws InterruptedException {
        HomePage home = new HomePage(driver);


        home.search(query);


        home.addToCart10Times();



        Thread.sleep(1000);



    }
}
