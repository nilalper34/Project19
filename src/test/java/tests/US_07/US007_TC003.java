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

public class US007_TC003 {

    @Test
    public void test003() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den Node Js seceneginin var oldugunu test eder
        Assert.assertEquals(page.nodeJsText.getText(),"Node Js","Node Js secenegi goronmuyor...");

        //  11-Node Js ı tiklar
        page.nodeJsBox.click();

        //  12-Node Js ın tıklandigini test eder
        Assert.assertTrue(page.nodeJsBox.isSelected(),"Node Js box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Node Js box tiklandi..." ,page.nodeJsText);

        Driver.getDriver().close();

    }
}
