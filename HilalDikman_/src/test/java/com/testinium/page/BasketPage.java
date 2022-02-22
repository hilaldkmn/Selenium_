package com.testinium.page;

import com.testinium.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class BasketPage {
        Methods methods;

        Logger logger = LogManager.getLogger(com.testinium.page.ProductPage.class);

        public  BasketPage(){
            methods = new Methods();
        }

        public void basket(){
            methods.findElement(By.xpath("(//*[@class='mg-b-10'])["+ methods.random()+"]")).click();
            //Yazdığım random methodunu çağırarak random kitap aratılır
            methods.waitBySeconds(4);
            methods.scrollWaitAction(By.cssSelector("a.add-to-cart.btn-orange.btn-ripple")); //Sepete eklenir.
            methods.waitBySeconds(2);
            methods.click(By.cssSelector("a.add-to-cart.btn-orange.btn-ripple"));
            methods.waitBySeconds(2);
            methods.click(By.cssSelector("div.menu.top.my-list a.common-sprite")); //listerim objesine tıklanır
            methods.waitBySeconds(3);
            methods.click(By.xpath("//div[@class='menu top my-list']//a[text()='Favorilerim']")); //Listelerim altındaki favorilerim öğesine tıklanır.
            methods.waitBySeconds(1);
            methods.click(By.xpath("//div[@class='product-cr'][3]//i[@class='fa fa-heart-o']")); //3. ürün silinir.
            methods.waitBySeconds(3);
            methods.click(By.id("cart-items")); //sepetim öğesine tıklanır
            methods.waitBySeconds(1);
            methods.click(By.id("js-cart")); // açılan bölümden sepetime git denir
            methods.waitBySeconds(3);
            methods.findElement(By.xpath("//input[@name='quantity']")).clear(); //Sepetimdeki ürün adet sayısı silinir
            methods.sendKey(By.xpath("//input[@name='quantity']"),"2"); //Ürün adet sayısı artırımı yapılır
            methods.waitBySeconds(2);
            methods.click(By.xpath("//i[@title='Güncelle']")); //Ürün adet sayısı güncellenir
            methods.waitBySeconds(2);
            methods.click(By.xpath("//div[@class='right']//a[@class='button red']")); //Ürün satın al tıklanır
            methods.waitBySeconds(2);
            methods.click(By.xpath("//a[text()='Yeni bir adres kullanmak istiyorum.']"));
            //Yukarıda bunu kullanmamın sebebi adresimi daha önce test koşarken kaydetmesi.
            //O yüzden yeni adres ekleyerek zaten alınmış olan adresin üstüne yazmamak.
            methods.waitBySeconds(2);
            methods.sendKey(By.xpath("//input[@name='firstname_companyname']"),"Hilal"); //Ad girilir.
            methods.waitBySeconds(2);
            methods.sendKey(By.xpath("//input[@name='lastname_title']"),"Dikman"); //Soyad girilir
            methods.waitBySeconds(2);
            methods.selectByText(By.cssSelector("#address-zone-id"),"İstanbul" ); //Şehir bilgisi girilir
            methods.waitBySeconds(1);
            methods.selectByText(By.cssSelector("#address-county-id"),"ÜMRANİYE" ); //İlçe bilgisi girilir
            methods.waitBySeconds(1);
            methods.sendKey(By.id("address-address-text"),"Testinium"); //Tam adres bilgisi girilir
            methods.waitBySeconds(1);
            methods.sendKey(By.id("address-telephone"),"3333333333"); //Telefon girilir
            methods.waitBySeconds(1);
            methods.sendKey(By.id("address-mobile-telephone"),"5333333333"); //Mobil telefon girilir
            methods.waitBySeconds(1);
            methods.click(By.xpath("//button[@id='button-checkout-continue']")); //Devam tuşuna basılır
            methods.waitBySeconds(2);
            methods.click(By.xpath("//button[@id='button-checkout-continue']")); //Kargo methodu bölümünde devam tuşuna basılır ve ödeme methodu bölümüne girilir
            methods.waitBySeconds(2);
            methods.sendKey(By.xpath("//input[@id='credit-card-owner']"),"Hilal Dikman"); //Kredi kartı bilgileri Ad soyad girilir
            methods.waitBySeconds(2);
            methods.sendKey(By.xpath("//input[@id='credit_card_number_1']"),"1111111111111111"); //Kredi kartı numarası girilir
            methods.waitBySeconds(2);
            methods.selectByText(By.cssSelector("#credit-card-expire-date-month"),"02"); //Kredi kartı son kullanım tarihi ay girilir
            methods.waitBySeconds(2);
            methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"),"2026"); //Kredi kartı son kullanım tarihi yıl girilir
            methods.waitBySeconds(2);
            methods.sendKey(By.xpath("//input[@id='credit-card-security-code']"),"378"); //Güvenlik kodu girilir
            methods.waitBySeconds(2);
            methods.click(By.xpath("//label[@for='credit-card-is-3ds']")); //3D label kullanılır
            methods.waitBySeconds(2);
            methods.click(By.xpath("//button[@id='button-checkout-continue']")); //Devam tuşuna basılır
            methods.waitBySeconds(4);
            methods.click(By.xpath("//a[@class='checkout-logo']")); //Anasayfaya gidilir
            methods.waitBySeconds(2);
            methods.hoverMouse(By.xpath("//div[@class='menu top login']//a[@class='common-sprite']"));
            //hoverMause methodu yazdım ve böylelikle farenin üzerine gelmesi ile menü açılır
            methods.click(By.xpath("//a[text()='Çıkış']")); //Çıkış yapılır.
            methods.waitBySeconds(2);

        }
}
