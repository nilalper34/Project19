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

public class US007_TC006 {
    @Test
    public void test006() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den Skysuite Tech seceneginin var oldugunu test eder
        Assert.assertEquals(page.skySuiteTechText.getText(),"Skysuite Tech","Skysuite Tech secenegi goronmuyor...");

        //  11-Skysuite Tech ı tiklar
        page.skySuiteTechBox.click();

        //  12-Skysuite Tech ın tıklandigini test eder
        Assert.assertTrue(page.skySuiteTechBox.isSelected(),"Skysuite Tech box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Skysuite Tech box tiklandi...",page.skySuiteTechText);

        Driver.getDriver().close();

    }
}
