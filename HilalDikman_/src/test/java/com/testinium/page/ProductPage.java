package com.testinium.page;

import com.testinium.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;



public class ProductPage {
    Methods methods;

    Logger logger = LogManager.getLogger(ProductPage.class);

    public  ProductPage(){
        methods = new Methods();
    }

    public void searchProduct(){
        methods.sendKey(By.id("search-input"),"oyuncak"); // oyuncak terimini aranır.
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search")); //Arama butonuna tıklanır
        methods.waitBySeconds(2);
        methods.scrollWaitAction(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']")); //7. ürüne scroll yapılır.
        methods.waitBySeconds(2);

    }
    public void attributeTest(){
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"),"title");
        System.out.println("Alınan text: " + attribute);
        logger.info("alınan text: " + attribute);
        methods.waitBySeconds(5);
    }
    public void textControlTest(){
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text: " +text);
        logger.info("Alınan text: " +text);
        methods.waitBySeconds(5);
    }

    public void valueControlTest(){
        methods.sendKey(By.id("search-input"),"testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("Alınan text: "+value);
        logger.info("Alınan text: " +value);
        Assert.assertEquals("testinium",value);
        methods.waitBySeconds(5);

    }


}
