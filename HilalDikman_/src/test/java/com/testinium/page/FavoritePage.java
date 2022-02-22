package com.testinium.page;

import com.testinium.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FavoritePage {
    Methods methods;

    Logger logger = LogManager.getLogger(FavoritePage.class);

    public  FavoritePage(){
        methods = new Methods();
    }

    public void addFavorite(){
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart']")); // birinci ürün favorilere eklenir
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart']")); // ikinci ürün favorilere eklenir
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']")); // üçüncü ürün favorilere eklenir
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart']")); // dördüncü ürün favorilere eklenir
        methods.waitBySeconds(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart red']"))); // birinci ürün favorilere eklenmiş olması kontrol yapılır.
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart red']"))); // ikinci ürün favorilere eklenmiş olması kontrol yapılır.
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart red']"))); // üçüncü ürün favorilere eklenmiş olması kontrol yapılır.
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart red']"))); // dördüncü ürün favorilere eklenmiş olması kontrol yapılır.
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='logo-icon']//a")); // anasayfaya gidilir
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='lvl1catalog']//a[@class='common-sprite']")); // puan kataloğuna tıklanır
        methods.waitBySeconds(2);
        methods.scrollWaitAction(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']")); //Türk klasiklerine scroll yapılır
        methods.waitBySeconds(1);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']")); //Türk klasikleri seçilir
        methods.waitBySeconds(1);
        methods.selectByText(By.cssSelector(".sort select"),"Yüksek Oylama"); //Açılan sayfada filtreleme alanından “Yüksek Oylama” seçimi yapılır
        methods.waitBySeconds(1);
        methods.click(By.xpath("//span[text()='Tüm Kitaplar']")); //Tüm kitaplara tıklanır.
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[text()='Hobi']")); //Tüm kitapların altındaki Hobi yazına tıklanır
        methods.waitBySeconds(1);
    }
}
