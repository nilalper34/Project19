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

public class US006_TC011 {

    @Test
    public void test011() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den New Arrivals seceneginin var oldugunu test eder
        Assert.assertEquals(page.newArrivalsText.getText(),"New Arrivals","New Arrivals secenegi goronmuyor...");

        //  11-New Arrivals ı tiklar
        page.newArrivalsBox.click();

        //  12-New Arrivals ın tıklandigini test eder
        Assert.assertTrue(page.newArrivalsBox.isSelected(),"New Arrivals box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("New Arrivals box",page.newArrivalsText);

        Driver.getDriver().close();


    }
}
