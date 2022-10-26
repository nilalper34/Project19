package tests.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Ahmetpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US21_TC01 {
    @Test
    public void tc01() throws InterruptedException {
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

        //7- Vendor "Sign Out" butonuna tiklar
        pages.signOut.click();

        //8-  Vendor "Store Manager" a tiklar
        pages.storeManager.click();

        //9- Vendor "Reports" a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        pages.reports.click();

        //10- Vendor  "Sales by date " butonuna tiklar
        pages.salesByDate.click();

        //11- Vendor "Years"in erisilebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.yearButonu.isEnabled());

        //12- Vendor "Years" butonuna tiklar
        Thread.sleep(2000);
        pages.yearButonu.click();

        //13- Vendor "Years"in icindeki rakamlar tablosunun gorulebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.tablo.isDisplayed());

        //14- Vendor "Years"in icindeki grafik tablonun gorulebilir oldugunu dogrular
        Assert.assertTrue(pages.grafik.isDisplayed());

        //15- Vendor "Last Month"in erisilebilir oldugunu dogrular
        Assert.assertTrue(pages.lastMonth.isEnabled());

        //16- Vendor "Last Month" butonuna tiklar
        pages.lastMonth.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //17- Vendor "Last Month"un icindeki rakamlar tablosunun gorulebilir oldugunu dogrular
        Assert.assertTrue(pages.tablo.isDisplayed());

        //18- Vendor "Last Month"un icindeki grafik tablonun gorulebilir oldugunu dogrular
        Assert.assertTrue(pages.grafik.isDisplayed());

        //19- Vendor "This Month"un erisilebilir oldugunu dogrular
        Assert.assertTrue(pages.thisMonth.isEnabled());

        //20- Vendor "This Mont" butonuna tiklar
        pages.thisMonth.click();

        //21- Vendor "This Mont"un icindeki rakamlar tablosunun gorulebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.tablo.isDisplayed());

        //22- Vendor "This Mont"un icindeki grafik tablonun gorulebilir oldugunu dogrular
        Assert.assertTrue(pages.grafik.isDisplayed());

        //23- Vendor "Last 7 Days"in erisilebilir oldugunu dogrular
        Assert.assertTrue(pages.last7Days.isEnabled());

        //24- Vendor "Last 7 Dayst" butonuna tiklar
        pages.last7Days.click();

        //25- Vendor "Last 7 Days"in icindeki tablonun gorulebilir oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.tablo.isDisplayed());

        //26- Vendor "Last 7 Days"in icindeki tablonun gorulebilir oldugunu dogrular
        Assert.assertTrue(pages.grafik.isDisplayed());



    }
}
