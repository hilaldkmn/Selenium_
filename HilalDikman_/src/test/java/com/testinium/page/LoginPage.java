package com.testinium.page;

import com.testinium.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {  //login olduğum sayfa burasıdır
    Methods methods;

    public LoginPage(){
        methods = new Methods();
    }

    public void login(){
        methods.click(By.cssSelector(".menu-top-button.login>a")); // login sayfası açılır
        methods.waitBySeconds(5);
        methods.sendKey(By.id("login-email"),"hilal.dikman@testinium.com"); //mail girilir
        methods.waitBySeconds(3);
        methods.sendKey(By.id("login-password"),"1q2w3e4r5t"); // şifre girilir
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));  //butona basılır ve giriş yapılır
        methods.waitBySeconds(15);

        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".section"))); //sayfaya login olması kontrolu yapılır

    }

}
