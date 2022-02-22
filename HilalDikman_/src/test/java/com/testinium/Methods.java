package com.testinium;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    Logger logger = LogManager.getLogger(Methods.class); //rapor formatında loglama yapıcak


    public Methods(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofMillis(300)).
                ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by){
        findElement(by).click();
    }
    public void sendKey(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False", e.getMessage());
            return false;
        }
    }
    public void scrollWaitAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }
    public String getAttribute(By by, String attiribute){
        return findElement(by).getAttribute(attiribute);
    }
    public String getText(By by){
        return findElement(by).getText();
    }
    public String  getValue(By by){
        return jsdriver.executeScript("return arguments[0].value;",findElement(by)).toString();
    }
    public void scrollWithJavaScript(By by){
        jsdriver.executeScript("arguments[0].scrollInfoView();",findElement(by));
    }

    public int random(){  //random sayı üretme methodu yazdım
        Random rnd = new Random();
        int deger = rnd.nextInt(3)+2;
        return deger;

    }
    public void hoverMouse(By by){ //imlecin üzerine gelmesi ile tıklamadan aççılır menünün açılması
        Actions actions = new Actions(driver);                 //ve alt elemente tıklanması methodunu yazdım.
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
    }
}
