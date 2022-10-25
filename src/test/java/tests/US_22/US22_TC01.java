package tests.US_22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US22_TC01 {
    @Test
    public void test01() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Anasayfada trending kategorisinin oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mustafaPgc.trendingKategori.isEnabled());
        //  3- Anasayfada new arrivals kategorisinin oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mustafaPgc.newArrivalsKategori.isEnabled());
        //  4- Anasayfada Best Seller kategorisinin oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mustafaPgc.bestSellerKategori.isEnabled());

        //ReusableMethods.getScreenshot("US22_TC01 ");
        Driver.closeDriver();

    }
}
