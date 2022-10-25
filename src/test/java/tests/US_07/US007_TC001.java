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

public class US007_TC001 {
    @Test
    public void test001() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den Elegant Auto Group seceneginin var oldugunu test eder
        Assert.assertEquals(page.elegantAutoGroupText.getText(),"Elegant Auto Group","Elegant Auto Group secenegi gorunmuyor...");

        //  11-Elegant Auto Group a tiklar
        page.elegantAutoGroupBox.click();

        //  12-Elegant Auto Group un tıklandigini test eder
        Assert.assertTrue(page.elegantAutoGroupBox.isSelected(),"Elegant Auto Group box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Elegant Auto Group box tiklandi...." ,page.elegantAutoGroupText);

        Driver.getDriver().close();
    }
}
