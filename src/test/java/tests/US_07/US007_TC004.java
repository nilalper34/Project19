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

public class US007_TC004 {

    @Test
    public void test004() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den NS8 seceneginin var oldugunu test eder
        Assert.assertEquals(page.nS8Text.getText(),"NS8","NS8 secenegi gorunmuyor...");

        //  11-NS8 ı tiklar
        page.nS8Box.click();

        //  12-NS8 ın tıklandigini test eder
        Assert.assertTrue(page.nS8Box.isSelected(),"NS8 box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("NS8 box tiklandi..",page.nS8Text);

        Driver.getDriver().close();
    }
}
