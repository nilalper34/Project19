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

public class US006_TC009 {

    @Test
    public void test009() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Toys&Games seceneginin var oldugunu test eder
        Assert.assertEquals(page.toysAndGamesText.getText(),"Toys & Games","Toys&Games secenegi gorunmuyor...");

        //  11-Toys&Games ı tiklar
        page.toysAndGamesBox.click();

        //  12-Toys&Games ın tıklandigini test eder
        Assert.assertTrue(page.toysAndGamesBox.isSelected(),"Toys&Games box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Toys&Games box",page.toysAndGamesText);

        Driver.getDriver().close();

   }
}
