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

public class US007_TC002 {

    @Test
    public void test002() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Product Brands den Green Grass seceneginin var oldugunu test eder
        Assert.assertEquals(page.greenGrassText.getText(),"Green Grass","Green Grass secenegi goronmuyor...");

        //  11-Green Grass ı tiklar
        page.greenGrassBox.click();

        //  12-Green Grass ın tıklandigini test eder
        Assert.assertTrue(page.greenGrassBox.isSelected(),"Green Grass box tiklanamadi...");

        ReusableMethods.getScreenshotWebElement("Green Grass box tiklanndi...",page.greenGrassText);

        Driver.getDriver().close();

    }
}
