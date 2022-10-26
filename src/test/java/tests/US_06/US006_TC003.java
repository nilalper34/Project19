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

public class US006_TC003 {

    @Test
    public void test003() throws InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Electronics seceneginin var oldugunu test eder
        Assert.assertEquals(page.electronicsText.getText(),"Electronics" , "Electronics gorunmuyor...");

        //  11-Electronics ı tiklar
        page.electronicsBox.click();

        //  12-Electronics ın tıklandigini test eder
        Assert.assertTrue(page.electronicsBox.isSelected() ,"Electronics box tiklanamadi...");

        try {
            ReusableMethods.getScreenshotWebElement("Electronics box",page.electronicsText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Driver.getDriver().close();
    }
}
