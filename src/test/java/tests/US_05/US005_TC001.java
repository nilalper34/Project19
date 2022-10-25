package tests.US_05;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;
import java.util.List;


public class US005_TC001 {

    @Test
    public void test01() throws InterruptedException, IOException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //  9-Store Manager urun listesinin gorunur oldugunu test eder
        List<WebElement> urunListesi = page.urunIsimList;
        Thread.sleep(3000);
        System.out.println(urunListesi.size());
        ReusableMethods.getScreenshot("Urun Listesi...");
        for (WebElement w : urunListesi) {
            ReusableMethods.waitForVisibility(w,10);
            Assert.assertTrue(w.isDisplayed(), "Urun listesi gorunur degil...");
            //ilgili Webelementin ekran goruntusunu alma
            try {
                ReusableMethods.waitForVisibility(w,20);
                ReusableMethods.getScreenshotWebElement("URUN LISTESI GORUNURLUGU...",w);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            //  10-Store Manager Status baslıgının gorunurlugunu test eder
            Assert.assertTrue(page.status.isDisplayed(),"Status baslıgı gorunmuyor...");

            //  11-Store Manager Stock baslıgının gorunurlugunu test eder
            Assert.assertTrue(page.stock.isDisplayed(),"Stock baslıgı gorunmuyor...");

            //  12-Store Manager Price baslıgının gorunurlugunu test eder
            Assert.assertTrue(page.price.isDisplayed(),"Price baslıgı gorunmuyor...");

            //  13-Store Manager Date baslıgının gorunurlugunu test eder
            Assert.assertTrue(page.date.isDisplayed(),"Date baslıgı gorunmuyor...");

            Driver.getDriver().close();

        }
    }
