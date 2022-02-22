package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.BasketPage;
import com.testinium.page.FavoritePage;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class BasketTest extends BaseTest {

    @Test
    public void basketTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        FavoritePage favoritePage = new FavoritePage();
        BasketPage basketPage = new BasketPage();

        loginPage.login();
        productPage.searchProduct();
        favoritePage.addFavorite();
        basketPage.basket();

    }
}
