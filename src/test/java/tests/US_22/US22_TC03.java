package tests.US_22;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US22_TC03 {
    @Test
    public void test03() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Shop Now butonuna tiklar
        mustafaPgc.shopNowButonu.click();
        //  3- Dropdown menude Sort by : Default Sorting uzerine tiklar
        mustafaPgc.dropDownMenu.click();
        //  4- Dropdown menude Sort by popularity uzerine tiklar
        Select select = new Select(mustafaPgc.dropDownMenu);
        ReusableMethods.waitFor(2);
        select.selectByIndex(1);
        //  5- Urunlerin populerlige (popularity) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("popularity"));
        //  6- Dropdown menude Sort by average rating uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(2);
        //  7- Urunlerin en cok oy alana (rating) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("rating"));
        //  8- Dropdown menude Sort by latest uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(3);
        //  9- Urunlerin en yeniye(date) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("date"));
        //  10- Dropdown menude Sort by price:low to high uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(4);
        //  11- Urunlerin dusukten yuksek fiyata (price) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("price"));
        //  12- Dropdown menude Sort by price:high to low uzerine tiklar
        ReusableMethods.waitFor(5);
        select.selectByIndex(5);
        //  13- Urunlerin yuksekten dusuk fiyata (price-desc) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("price-desc"));

        //ReusableMethods.getScreenshot("US22_TC03 ");

        Driver.closeDriver();

    }
}
