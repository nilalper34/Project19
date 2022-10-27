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

public class US006_TC010 {

    @Test
    public void test010() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Accessories seceneginin var oldugunu test eder
        Assert.assertEquals(page.accessoriesText.getText(),"Accessories","Accessories secenegi gorunmuyor...");

        //  11-Accessories ı tiklar
        page.accessoriesBox.click();

        //  12-Accessories ın tıklandigini test eder
        Assert.assertTrue(page.accessoriesBox.isSelected(),"Accessories box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Accessories box" , page.accessoriesText);

        Driver.getDriver().close();

    }
}
