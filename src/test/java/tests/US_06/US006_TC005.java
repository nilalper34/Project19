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

public class US006_TC005 {

    @Test
    public void test005() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Uncategorized sekmesi acılır
        page.uncategorizedSekmesi.click();

        //  11-INDIRIMLI URUNLER seceneginin var oldugunu test eder
        Assert.assertEquals(page.indirimliUrunlerText.getText(),"  INDIRIMLI URUNLER","INDIRIMLI URUNLER goronmuyor...");

        //  12-INDIRIMLI URUNLER ı tiklar
        page.indirimliUrunlerBox.click();

        //  13-INDIRIMLI URUNLER ın tıklandigini test eder
        Assert.assertTrue(page.indirimliUrunlerBox.isSelected(),"INDIRIMLI URUNLER tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("indirimliUrunler box",page.indirimliUrunlerText);


        Driver.getDriver().close();
    }
}
