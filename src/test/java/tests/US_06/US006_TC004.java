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

public class US006_TC004 {

    @Test
    public void test004() throws InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Home & Garden seceneginin var oldugunu test eder
        Assert.assertEquals(page.homeAndGardenText.getText(),"Home & Garden" , "Home & Garden gorunmuyor...");

        //  11-Home & Garden ı tiklar
        page.homeAndGardenBox.click();

        //  12-Home & Garden ın tıklandigini test eder
        Assert.assertTrue(page.homeAndGardenBox.isSelected() ,"Home & Garden box tiklanamadi...");

        try {
            ReusableMethods.getScreenshotWebElement("Home & Garden box",page.homeAndGardenText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Driver.getDriver().close();
    }
}
