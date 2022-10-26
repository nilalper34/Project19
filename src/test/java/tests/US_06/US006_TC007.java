package tests.US_06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US006_TC007 {
    @Test
    public void test007() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Men sekmesi acılır
        page.menSekmesi.click();

        //  11-Cosmetic in var oldugunu test eder
        Assert.assertEquals(page.cosmeticText1.getText(),"  Cosmetic","Cosmetic sekmesi gorunmuyor...");

        //  12-Cosmetic i tiklar
        page.cosmeticBox1.click();

        //  13-Cosmetic in tiklandigini test eder
        Assert.assertTrue(page.cosmeticBox1.isSelected(),"CosmeticBox1 tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("cosmeticBox1 box",page.cosmeticText1);

        Driver.getDriver().navigate().refresh();

        //  14-Categories den Women sekmesi acılır
        page.womenSekmesi.click();

        //  15-Cosmetic in var oldugunu test eder
        Assert.assertEquals(page.cosmeticText2.getText(),"  Cosmetic","Cosmetic sekmesi gorunmuyor...");

        //  16-Cosmetic i tiklar
        page.cosmeticBox2.click();

        //  17-Cosmetic in tiklandigini test eder
        Assert.assertTrue(page.cosmeticBox2.isSelected(),"CosmeticBox2 tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("cosmeticBox2 box",page.cosmeticText2);

        Driver.getDriver().close();

    }
}
