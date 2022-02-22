package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.FavoritePage;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class FavoriteTest extends BaseTest {
    @Test
    public void favoriteTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        FavoritePage favoritePage = new FavoritePage();

        loginPage.login();
        productPage.searchProduct();
        favoritePage.addFavorite();
    }
}
