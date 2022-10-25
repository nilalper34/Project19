package tests.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Ahmetpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US21_TC04 {
    @Test
    public void tc04() throws InterruptedException {
        //1- Vendor https://hubcomfy.com/ adresine gider
        String hbcUrl= ConfigReader.getProperty("hubcomfyUrl");
        Driver.getDriver().get(hbcUrl);

        //2- Vendor sign in butonuna tıklar
        Ahmetpgc pages= new Ahmetpgc();
        pages.ilkSigIn.click();

        //3- Vendor gecerli email adresini girer
        //4- Vendor gecerli password girer
        //5- Vendor "Sign In" butonuna tiklar
        Actions actions= new Actions(Driver.getDriver());
        pages.gmail.sendKeys(ConfigReader.getProperty("ahmetGmail"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("ahmetPassword"))
                .sendKeys(Keys.ENTER).perform();

        //6- Vendor "Sign Out" butonuna tiklar
        pages.signOut.click();

        //7-  Vendor "Store Manager" a tiklar
        pages.storeManager.click();

        //8- Vendor "Reports" a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        pages.reports.click();

        //9- Vendor  "Sales by product " butonuna tiklar
        pages.salesByProduct.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //10- Vendor "Custom"in erisilebilir oldugunu dogrular
        Assert.assertTrue(pages.custom.isEnabled());

        //11- Vendor "Custom" butonuna tiklar
        pages.custom.click();
        Thread.sleep(2000);

        //12- Vendor "Custom"dan bir tarih araligi secer
        pages.ilkTarih.click();
        pages.sonTarih.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //13- Vendor bir urun secer ve tiklar
        Thread.sleep(2000);
        pages.urun.click();


        //14- Vendor ""Custom" da acilan urunler tablosunun gorulebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.tablo.isDisplayed());

        //15- Vendor ""Custom" da acilan grafik tablosunun gorulebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}
