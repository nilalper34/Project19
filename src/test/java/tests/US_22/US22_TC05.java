package tests.US_22;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.MustafaMethods;
import utilities.ReusableMethods;

import java.io.IOException;

public class US22_TC05 {
    @Test
    public void test05() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Shop Now butonuna tiklar
        ReusableMethods.waitFor(2);
        mustafaPgc.shopNowButonu.click();
        //  3- Dropdown menuden Sort by price:high to low uzerine tiklar
        Select select = new Select(mustafaPgc.dropDownMenu);
        ReusableMethods.waitFor(3);
        select.selectByIndex(5);
        ReusableMethods.waitFor(3);
        //  4- Ekrana gelen urunlerin yuksek fiyattan dusuk fiyata dogru siralandigini test eder
        ReusableMethods.waitFor(10);

        /* Ekrana gelen urunlerin listesi (actualHighList) ile ekrana gelen urunlerin buyukten kucuge
        sıralı listesi (expectedHighList) nin esitligi karsılastırılarak test yapilmistir. */

        Assert.assertEquals(MustafaMethods.actualHighList, MustafaMethods.expectedHighList);
        //ReusableMethods.getScreenshot("US22_TC05 ");

        Driver.closeDriver();
    }
}
