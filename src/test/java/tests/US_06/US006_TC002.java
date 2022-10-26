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


public class US006_TC002 {

    @Test
    public void test001() throws InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //10-Categories den Best Seller seceneginin var oldugunu test eder
        Assert.assertEquals(page.bestSellerText.getText() , "Best Seller","Best Seller goronmuyor...");

        //11-Best Seller ı tiklar
        page.bestSellerBox.click();

        //12-Best Seller ın tıklandigini test eder
        Assert.assertTrue(page.bestSellerBox.isSelected(),"Best Seller tiklanamadi...");

        try {
            ReusableMethods.getScreenshotWebElement("Best Seller box",page.bestSellerText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Driver.getDriver().close();
    }
}


