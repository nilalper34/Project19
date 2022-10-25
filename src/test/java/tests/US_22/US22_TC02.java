package tests.US_22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US22_TC02 {
    @Test
    public void test02() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Anasayfada trending kategorisinde tumunu gor linki oldugunu test eder
        Assert.assertTrue(mustafaPgc.trendingTumunuGor.isDisplayed());
        //  3- Trending kategorisindeki tumunu gor linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        mustafaPgc.trendingTumunuGor.click();
        //  4- Trending kategorisinin ana sayfasina gidildigini test eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("trending"));
        //  5- Site anasayfasına geri gider
        mustafaPgc.anaSayfa.click();
        //  6- New arrivals kategorisindeki tumunu gor linkini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        mustafaPgc.newArrivalsTumunuGor.click();
        //  7- New arrivals kategori sayfasina gidildigini test eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("arrivals"));
        //  8- Site anasayfasına geri gider
        mustafaPgc.anaSayfa.click();
        //  9- Best Seller kategorisindeki tumunu gor linkini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        mustafaPgc.BestSellerTumunuGor.click();
        //  10- Best Seller kategori sayfasina gidildigini test eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("best"));

        //ReusableMethods.getScreenshot("US22_TC02 ");

        Driver.closeDriver();
    }
}
