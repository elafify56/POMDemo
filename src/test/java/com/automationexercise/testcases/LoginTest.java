package com.automationexercise.testcases;

import com.automationexercise.base.BaseTest;
import com.automationexercise.listeners.TestNGListeners;
import com.automationexercise.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class LoginTest extends BaseTest {

    private String email = "tikyzude@mailinator.com";
    private String password = "Pa$$w0rd!";


    @Test
    public void shouldBeAbleToLogin(){
        LoginPage login = new LoginPage(driver);

        login.goToLoginPage();
        login.fillLoginForm(email , password);

        soft.assertTrue(login.isLoggedIn());

        soft.assertAll();
    }

    @Test
    public void failTC(){

        soft.assertTrue(false);
        soft.assertAll();
    }

}
