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

public class US006_TC008 {
    @Test
    public void test008() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Moda&Giyim seceneginin var oldugunu test eder
        Assert.assertEquals(page.modaAndGiyimText.getText(), "Moda&Giyim", "Moda&Giyim secenegi gorunmuyor...");

        //  11-Moda&Giyim ı tiklar
        page.modaAndGiyimBox.click();

        //  12-Moda&Giyim ın tıklandigini test eder
        Assert.assertTrue(page.modaAndGiyimBox.isSelected(), "Moda & Giyim box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Moda&Giyim box", page.modaAndGiyimText);

        Driver.getDriver().close();

   }
}
