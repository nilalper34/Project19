package tests.US_05;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US005_TC005 {

    @Test
    public void test005() throws InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 10-Urun icin"Short Description" seceneginin oldugunu test eder
        Assert.assertEquals(page.shortDescriptionText.getText() ,"Short Description");

        // 11-Urun icin "Description" seceneginin oldugunu test eder
        Assert.assertEquals(page.descritionText.getText() , "Description");

        try {
            ReusableMethods.getScreenshot("Short Description ve Description seçenekleri..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Driver.getDriver().close();


    }
}
