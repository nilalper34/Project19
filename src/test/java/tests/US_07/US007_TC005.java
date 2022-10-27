package tests.US_07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US007_TC005 {

    @Test
    public void test005() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den RED seceneginin var oldugunu test eder
        Assert.assertEquals(page.redText.getText(),"RED","RED secenegi gorunmuyor...");

        //  11-RED ı tiklar
        page.redBox.click();

        //  12-RED ın tıklandigini test eder
        Assert.assertTrue(page.redBox.isSelected(),"RED box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("RED box tiklandi...",page.redText);

        Driver.getDriver().close();

    }
}
