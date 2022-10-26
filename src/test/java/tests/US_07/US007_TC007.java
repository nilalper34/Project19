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

public class US007_TC007 {

    @Test
    public void test007() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den Sterling seceneginin var oldugunu test eder
        Assert.assertEquals(page.sterlingText.getText(),"Sterling","Sterling secenegi gorunmuyor...");

        //  11-Sterling ı tiklar
        page.sterlingBox.click();

        //  12-Sterling ın tıklandigini test eder
        Assert.assertTrue(page.sterlingBox.isSelected(),"Sterling box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Sterling box tiklandi..",page.sterlingText);

        Driver.getDriver().close();

    }
}
