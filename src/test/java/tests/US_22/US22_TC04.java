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

public class US22_TC04 {
    @Test
    public void test04() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Shop Now butonuna tiklar
        mustafaPgc.shopNowButonu.click();
        //  3- Dropdown menuden Sort by price:low to high uzerine tiklar
        Select select = new Select(mustafaPgc.dropDownMenu);
        ReusableMethods.waitFor(3);
        select.selectByIndex(4);
        ReusableMethods.waitFor(2);
        //  4- Ekrana gelen urunlerin dusuk fiyattan yuksek fiyata dogru siralandigini test eder

        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        /* Ekrana gelen urunlerin listesi (actualLowList) ile ekrana gelen urunlerin kucukten buyuge
        sıralı listesi (expectedLowList) nin esitligi karsılastırılarak test yapilmistir. */

        Assert.assertEquals(MustafaMethods.actualLowList, MustafaMethods.expectedLowlist);

        //ReusableMethods.getScreenshot("US22_TC04 ");

        Driver.closeDriver();

    }
}
